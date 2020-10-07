package com.example.home_details_future.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.domain.interactor.ComicsUseCase
import com.example.domain.interactor.EventUseCase
import javax.inject.Inject

class HomeViewModel @Inject constructor (
    charactersUseCase: ComicsUseCase,
    eventUseCase: EventUseCase
) : ViewModel() {

    val comics = charactersUseCase.execute().cachedIn(viewModelScope)

    val events = eventUseCase.execute().cachedIn(viewModelScope)
}