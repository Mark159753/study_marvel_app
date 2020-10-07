package com.example.data.datasourcess.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.data.datasourcess.abstraction.RemoteDataSource
import com.example.data.datasourcess.local.MarvelLocalDatabase
import com.example.data.datasourcess.remote.LoadStatus
import com.example.data.model.entitys.EventResponse
import com.example.data.model.entitys.RemoteKeys
import java.io.IOException
import java.io.InvalidObjectException

private const val MARVEL_STARTING_PAGE_INDEX = 0

@OptIn(ExperimentalPagingApi::class)
class EventRemoteMediator(
    private val marvelLocalDatabase: MarvelLocalDatabase,
    private val apiService: RemoteDataSource
):RemoteMediator<Int, EventResponse>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, EventResponse>
    ): MediatorResult {
        val page = when (loadType) {
            LoadType.REFRESH -> {
                val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                remoteKeys?.nextKey?.minus(state.config.pageSize) ?: MARVEL_STARTING_PAGE_INDEX
            }
            LoadType.PREPEND -> {
                val remoteKeys = getRemoteKeyForFirstItem(state)
                if (remoteKeys == null) {
//                    throw InvalidObjectException("Remote key and the prevKey should not be null")
                    return MediatorResult.Error(InvalidObjectException("Remote key and the prevKey should not be null"))
                }
                val prevKey = remoteKeys.prevKey
                if (prevKey == null) {
                    return MediatorResult.Success(endOfPaginationReached = true)
                }
                remoteKeys.prevKey
            }
            LoadType.APPEND -> {
                val remoteKeys = getRemoteKeyForLastItem(state)
                if (remoteKeys == null || remoteKeys.nextKey == null) {
//                    throw InvalidObjectException("Remote key should not be null for $loadType")
                    return MediatorResult.Error(InvalidObjectException("Remote key should not be null for $loadType"))
                }
                remoteKeys.nextKey
            }
        }

        val apiResponse = apiService.getEvents(page, state.config.pageSize)

        when(apiResponse){
            is LoadStatus.Success ->{
                val items = apiResponse.data.data.results
                val endOfPaginationReached = items.isEmpty()

                marvelLocalDatabase.withTransaction {
                    if (loadType == LoadType.REFRESH){
                        marvelLocalDatabase.getRemoteKeysDao().deleteByItemType(RemoteKeys.EVENTS_TYPE)
                        marvelLocalDatabase.getEventsDao().deleteAll()
                    }
                    val prevKey = if (page == MARVEL_STARTING_PAGE_INDEX) null else page - state.config.pageSize
                    val nextKey = if (endOfPaginationReached) null else page + state.config.pageSize
                    val keys = items.map{
                        RemoteKeys(RemoteKeys.EVENTS_TYPE, it.id, prevKey, nextKey)
                    }
                    marvelLocalDatabase.getRemoteKeysDao().insert(keys)
                    marvelLocalDatabase.getEventsDao().insert(items)
                }
                return MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
            }
            is LoadStatus.ConnectionError -> {
                return MediatorResult.Error(apiResponse.e ?: IOException("Unknown Error"))
            }
            else ->{
                val err = apiResponse as LoadStatus.Error
                return MediatorResult.Error(err.e ?: IOException("Unknown Error"))
            }
        }
    }


    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, EventResponse>): RemoteKeys? {
        return state.pages.lastOrNull() { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { item ->
                marvelLocalDatabase.getRemoteKeysDao().remoteKeysRepoId(item.id, RemoteKeys.EVENTS_TYPE)
            }
    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, EventResponse>): RemoteKeys? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { item ->
                marvelLocalDatabase.getRemoteKeysDao().remoteKeysRepoId(item.id, RemoteKeys.EVENTS_TYPE)
            }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, EventResponse>
    ): RemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { characterId ->
                marvelLocalDatabase.getRemoteKeysDao().remoteKeysRepoId(characterId, RemoteKeys.EVENTS_TYPE)
            }
        }
    }
}