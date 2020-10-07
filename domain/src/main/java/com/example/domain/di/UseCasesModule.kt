package com.example.domain.di

import com.example.domain.interactor.CharactersUseCase
import com.example.domain.interactor.ComicsUseCase
import com.example.domain.interactor.EventUseCase
import com.example.domain.repository.MarvelRepository
import dagger.Module
import dagger.Provides

@Module
object UseCasesModule {

    @MarvelDataScope
    @JvmStatic
    @Provides
    fun provideCharactersUseCase(repository: MarvelRepository):CharactersUseCase{
        return CharactersUseCase(repository)
    }

    @MarvelDataScope
    @JvmStatic
    @Provides
    fun provideComicsUseCase(repository: MarvelRepository):ComicsUseCase{
        return ComicsUseCase(repository)
    }

    @MarvelDataScope
    @JvmStatic
    @Provides
    fun provideEventUseCase(repository: MarvelRepository):EventUseCase{
        return EventUseCase(repository)
    }
}