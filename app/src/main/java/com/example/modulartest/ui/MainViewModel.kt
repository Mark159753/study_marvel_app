package com.example.modulartest.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.domain.interactor.CharactersUseCase
import com.example.domain.interactor.MarvelUseCase
import com.example.domain.model.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val charactersUseCase: CharactersUseCase
):ViewModel() {

    val characters = charactersUseCase.execute().cachedIn(viewModelScope)

}