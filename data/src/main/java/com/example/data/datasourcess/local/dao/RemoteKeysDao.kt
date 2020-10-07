package com.example.data.datasourcess.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.data.model.entitys.RemoteKeys

@Dao
abstract class RemoteKeysDao:BaseDao<RemoteKeys>("remote_keys") {

    @Query("SELECT * FROM remote_keys WHERE itemId = :itemId AND itemType = :itemType")
    abstract suspend fun remoteKeysRepoId(itemId: Int, itemType:Int): RemoteKeys?

    @Query("DELETE FROM remote_keys WHERE itemType = :itemType")
    abstract suspend fun deleteByItemType(itemType: Int)

    @Query("DELETE FROM remote_keys")
    abstract suspend fun deleteAll()

}