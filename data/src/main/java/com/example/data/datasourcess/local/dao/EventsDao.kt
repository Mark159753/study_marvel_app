package com.example.data.datasourcess.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import com.example.data.model.entitys.EventResponse

@Dao
abstract class EventsDao:BaseDao<EventResponse>("EventResponse") {

    @Query("SELECT * FROM EventResponse ORDER BY title")
    abstract fun getAll(): PagingSource<Int, EventResponse>

    @Query("DELETE FROM EventResponse")
    abstract suspend fun deleteAll()
}