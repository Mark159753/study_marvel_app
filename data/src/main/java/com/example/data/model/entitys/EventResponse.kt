package com.example.data.model.entitys


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.model.response.Thumbnail

@Entity
data class EventResponse(
    val description: String,
    val end: String?,
    @PrimaryKey
    val id: Int,
    val modified: String,
    val resourceURI: String,
    val start: String?,
    @Embedded
    val thumbnail: Thumbnail,
    val title: String
)