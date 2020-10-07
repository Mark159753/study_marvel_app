package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.model.Character
import com.example.domain.model.Comics
import com.example.domain.model.Event
import com.example.domain.model.Series
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {
    fun getCharacters():Flow<PagingData<Character>>

    fun getComics(): Flow<PagingData<Comics>>

    fun getEvents(): Flow<PagingData<Event>>
//    fun getSeries(): Flow<PagingData<Series>>
}