package com.example.data.datasourcess.remote.api

import com.example.data.model.response.CharactersResponse
import com.example.data.model.response.ComicsResponse
import com.example.data.model.response.EventsResponse
import com.example.data.model.response.SeriesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {

    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Response<CharactersResponse>

    @GET("/v1/public/series")
    suspend fun getSeries(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Response<SeriesResponse>

    @GET("/v1/public/comics")
    suspend fun getComics(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
        @Query("orderBy") orderBy:String
    ): Response<ComicsResponse>

    @GET("/v1/public/events")
    suspend fun getEvents(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Response<EventsResponse>
}