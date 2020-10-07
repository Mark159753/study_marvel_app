package com.example.domain.interactor

import androidx.paging.PagingData
import com.example.domain.model.Character
import com.example.domain.repository.MarvelRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharactersUseCase @Inject constructor(
    private val repository: MarvelRepository
):MarvelUseCase<Flow<PagingData<Character>>> {

    override fun execute(): Flow<PagingData<Character>> {
        return repository.getCharacters()
    }
}