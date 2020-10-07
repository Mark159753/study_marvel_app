package com.example.home_details_future.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.home_details_future.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(model: HomeViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactoryDI): ViewModelProvider.Factory

}