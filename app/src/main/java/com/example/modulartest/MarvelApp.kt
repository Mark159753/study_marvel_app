package com.example.modulartest

import android.app.Application
import com.example.home_details_future.di.HomeDetailsInjector
import com.example.home_details_future.di.HomeDetailsComponent
import com.example.modulartest.di.DaggerApplicationComponent

class MarvelApp():Application(), HomeDetailsInjector {

    val appComponent = DaggerApplicationComponent.factory().create(this)

    override fun getFragmentComponent(): HomeDetailsComponent.Factory {
        return appComponent.getHomeDetailsComponent()
    }
}