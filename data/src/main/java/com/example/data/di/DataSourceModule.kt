package com.example.data.di

import com.example.data.datasourcess.abstraction.RemoteDataSource
import com.example.data.datasourcess.remote.RemoteDataSourceImpl
import com.example.data.repository.MarvelRepositoryImpl
import com.example.domain.di.MarvelDataScope
import com.example.domain.repository.MarvelRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataSourceModule {

    @Binds
    abstract fun bindRemoteDataSource(sourceImpl: RemoteDataSourceImpl):RemoteDataSource

    @Binds
    abstract fun bindMarvelRepository(repository: MarvelRepositoryImpl):MarvelRepository
}