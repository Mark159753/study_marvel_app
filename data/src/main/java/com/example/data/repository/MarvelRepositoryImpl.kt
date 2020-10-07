package com.example.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.data.datasourcess.abstraction.RemoteDataSource
import com.example.data.datasourcess.local.MarvelLocalDatabase
import com.example.data.datasourcess.paging.CharactersRemoteMediator
import com.example.data.datasourcess.paging.ComicsRemoteMediator
import com.example.data.datasourcess.paging.EventRemoteMediator
import com.example.data.mappers.CharacterMapper
import com.example.data.mappers.ComicsMapper
import com.example.data.mappers.EventMapper
import com.example.domain.model.Character
import com.example.domain.model.Comics
import com.example.domain.model.Event
import com.example.domain.repository.MarvelRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    private val remoteSource:RemoteDataSource,
    private val database: MarvelLocalDatabase
):MarvelRepository {

    private val characterMapper = CharacterMapper()
    private val comicsMapper = ComicsMapper()
    private val eventMapper = EventMapper()

    override fun getCharacters(): Flow<PagingData<Character>> {
        val source = {database.getCharacterDao().getAll()}
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            remoteMediator = CharactersRemoteMediator(database, remoteSource),
            pagingSourceFactory = source
        ).flow.map {
            it.map { item ->
                characterMapper.transform(item)
            }
        }
    }

    override fun getComics(): Flow<PagingData<Comics>> {
        val source = {database.getComicsDao().getAll()}
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            remoteMediator = ComicsRemoteMediator(database, remoteSource),
            pagingSourceFactory = source
        ).flow.map {
            it.map {item ->
                comicsMapper.transform(item)
            }
        }
    }

    override fun getEvents(): Flow<PagingData<Event>> {
        val source = {database.getEventsDao().getAll()}
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            remoteMediator = EventRemoteMediator(database, remoteSource),
            pagingSourceFactory = source
        ).flow.map { pagingData ->
            pagingData.map { eventMapper.transform(it) }
        }
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 25
    }
}