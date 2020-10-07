package com.example.data.datasourcess.local.dao

import androidx.room.*

@Dao
abstract class BaseDao<T>(private val tableName:String) {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(list: List<T>)



//    @RawQuery
//    protected abstract suspend fun deleteAll(query: SupportSQLiteQuery):Long
//
//    suspend fun deleteAll(){
//        val query = SimpleSQLiteQuery("DELETE FROM $tableName")
//        deleteAll(query)
//    }
}