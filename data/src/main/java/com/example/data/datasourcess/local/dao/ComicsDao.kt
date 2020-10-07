package com.example.data.datasourcess.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import com.example.data.model.entitys.ComicResponse

@Dao
abstract class ComicsDao:BaseDao<ComicResponse>("ComicResponse") {

    @Query("SELECT * FROM ComicResponse ORDER BY title")
    abstract fun getAll(): PagingSource<Int, ComicResponse>

    @Query("DELETE FROM ComicResponse")
    abstract suspend fun deleteAll()
}