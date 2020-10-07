package com.example.domain.interactor

import androidx.paging.PagingData
import com.example.domain.model.Event
import com.example.domain.repository.MarvelRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EventUseCase@Inject constructor(
    private val repository: MarvelRepository
):MarvelUseCase<Flow<PagingData<Event>>> {

    override fun execute(): Flow<PagingData<Event>> {
        return repository.getEvents()
    }
}