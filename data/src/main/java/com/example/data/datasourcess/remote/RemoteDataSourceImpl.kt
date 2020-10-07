package com.example.data.datasourcess.remote

import com.example.data.datasourcess.abstraction.RemoteDataSource
import com.example.data.datasourcess.remote.api.MarvelApi
import com.example.data.exception.NoConnectivityException
import com.example.data.model.response.CharactersResponse
import com.example.data.model.response.ComicsResponse
import com.example.data.model.response.EventsResponse
import com.example.data.model.response.SeriesResponse
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor (
    private val marvelApi: MarvelApi
): RemoteDataSource {

    override suspend fun getCharacters(offset: Int, limit: Int): LoadStatus<CharactersResponse> {
        return saveApiCall{marvelApi.getCharacters(offset, limit)}
    }

    override suspend fun getSeries(offset: Int, limit: Int): LoadStatus<SeriesResponse> {
        return saveApiCall{marvelApi.getSeries(offset, limit)}
    }

    override suspend fun getComics(offset: Int, limit: Int, orderBy:String): LoadStatus<ComicsResponse> {
        return saveApiCall{marvelApi.getComics(offset, limit, orderBy)}
    }

    override suspend fun getEvents(offset: Int, limit: Int): LoadStatus<EventsResponse> {
        return saveApiCall{marvelApi.getEvents(offset, limit)}
    }

    private suspend fun <T> saveApiCall(api:suspend () -> Response<T>):LoadStatus<T>{
        return try {
            val response = api.invoke()
            if (response.isSuccessful){
                val body = response.body()
                if (body == null || response.code() == 204)
                    LoadStatus.Error("Empty result", null)
                else
                    LoadStatus.Success<T>(body)
            }else{
                LoadStatus.Error("Unknown Error", null)
            }
        }catch (e:NoConnectivityException){
            LoadStatus.ConnectionError(e.message ?: "Unknown Error", e)
        }catch (e:Exception){
            LoadStatus.Error("Unknown Error", e)
        }
    }
}