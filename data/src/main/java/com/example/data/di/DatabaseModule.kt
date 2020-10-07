package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.datasourcess.local.MarvelLocalDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DatabaseModule {

    @JvmStatic
    @Provides
    @Singleton
    fun provideMarvelLocalDatabase(context: Context):MarvelLocalDatabase{
        return Room.databaseBuilder(context, MarvelLocalDatabase::class.java, MarvelLocalDatabase.DATABASE_NAME)
            .build()
    }
}