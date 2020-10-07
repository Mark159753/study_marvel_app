package com.example.data.datasourcess.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import com.example.data.model.entitys.SerieResponse

@Dao
abstract class SeriesDao:BaseDao<SerieResponse>("SerieResponse") {

    @Query("SELECT * FROM SerieResponse")
    abstract fun getAll(): PagingSource<Int, SerieResponse>
}