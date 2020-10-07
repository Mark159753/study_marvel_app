package com.example.data.model.entitys

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_keys")
data class RemoteKeys(
    val itemType:Int,
    val itemId:Int,
    val prevKey: Int?,
    val nextKey: Int?
) {
    @PrimaryKey(autoGenerate = true)
    var id:Long? = null


    companion object{
        const val CHARACTER_TYPE = 1
        const val COMICS_TYPE = 2
        const val EVENTS_TYPE = 3
        const val SERIES_TYPE = 4
    }
}