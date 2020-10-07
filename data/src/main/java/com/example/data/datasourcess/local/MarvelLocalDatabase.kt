package com.example.data.datasourcess.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.datasourcess.local.converter.ListCreatorsConverter
import com.example.data.datasourcess.local.dao.*
import com.example.data.model.entitys.*

@Database(
    entities = [
        CharacterResponse::class,
        ComicResponse::class,
        EventResponse::class,
        SerieResponse::class,
        RemoteKeys::class
    ],
    version = 1, exportSchema = false
)
@TypeConverters(
    ListCreatorsConverter::class
)
abstract class MarvelLocalDatabase:RoomDatabase() {

    abstract fun getCharacterDao():CharacterDao
    abstract fun getComicsDao():ComicsDao
    abstract fun getEventsDao():EventsDao
    abstract fun getSeriesDao():SeriesDao
    abstract fun getRemoteKeysDao():RemoteKeysDao

    companion object{
        const val DATABASE_NAME = "MarvelLocalDatabase"
    }
}