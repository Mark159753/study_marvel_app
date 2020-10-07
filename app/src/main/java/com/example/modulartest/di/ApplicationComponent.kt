package com.example.modulartest.di

import android.content.Context
import com.example.data.di.DataSourceModule
import com.example.data.di.DatabaseModule
import com.example.data.di.NetworkModule
import com.example.home_details_future.di.HomeDetailsComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DatabaseModule::class,
        NetworkModule::class,
        DataSourceModule::class
    ]
)
interface ApplicationComponent {

    fun getHomeDetailsComponent(): HomeDetailsComponent.Factory

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance applicationContext: Context):ApplicationComponent
    }
}