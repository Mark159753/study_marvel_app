package com.example.data.datasourcess.abstraction

import com.example.data.datasourcess.remote.LoadStatus
import com.example.data.model.response.CharactersResponse
import com.example.data.model.response.ComicsResponse
import com.example.data.model.response.EventsResponse
import com.example.data.model.response.SeriesResponse

interface RemoteDataSource {

    suspend fun getCharacters(offset: Int, limit: Int):LoadStatus<CharactersResponse>
    suspend fun getSeries(offset: Int, limit: Int):LoadStatus<SeriesResponse>
    suspend fun getComics(offset: Int, limit: Int, orderBy:String = "title"):LoadStatus<ComicsResponse>
    suspend fun getEvents(offset: Int, limit: Int):LoadStatus<EventsResponse>
}