package com.example.domain.interactor

import androidx.paging.PagingData
import com.example.domain.model.Comics
import com.example.domain.repository.MarvelRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ComicsUseCase @Inject constructor(
    private val repository: MarvelRepository
):MarvelUseCase<Flow<PagingData<Comics>>> {

    override fun execute(): Flow<PagingData<Comics>> {
        return repository.getComics()
    }
}