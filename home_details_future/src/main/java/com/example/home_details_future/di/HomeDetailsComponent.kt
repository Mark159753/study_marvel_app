package com.example.home_details_future.di

import com.example.domain.di.MarvelDataScope
import com.example.domain.di.UseCasesModule
import com.example.home_details_future.home.HomeFragment
import dagger.Subcomponent

@MarvelDataScope
@Subcomponent(modules = [
    ViewModelModule::class,
    UseCasesModule::class
])
interface HomeDetailsComponent {

    fun inject(fragment:HomeFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create():HomeDetailsComponent
    }
}