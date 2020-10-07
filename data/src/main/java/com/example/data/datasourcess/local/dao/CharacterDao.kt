package com.example.data.datasourcess.local.dao

import androidx.paging.PagingSource
import androidx.room.*
import com.example.data.model.entitys.CharacterResponse

@Dao
abstract class CharacterDao:BaseDao<CharacterResponse>("CharacterResponse") {

    @Query("SELECT * FROM CharacterResponse ORDER BY name")
    abstract fun getAll():PagingSource<Int, CharacterResponse>

    @Query("DELETE FROM CharacterResponse")
    abstract suspend fun deleteAll()

    @Query("SELECT * FROM CharacterResponse ORDER BY name LIMIT :limit OFFSET :offset")
    abstract suspend fun getByPage(limit:Int, offset:Int):List<CharacterResponse>
}