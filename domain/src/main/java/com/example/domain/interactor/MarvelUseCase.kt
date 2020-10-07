package com.example.domain.interactor

interface MarvelUseCase<T> {

    fun execute():T
}