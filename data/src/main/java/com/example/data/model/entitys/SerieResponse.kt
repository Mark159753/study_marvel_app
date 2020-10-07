package com.example.data.model.entitys


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.model.response.Thumbnail

@Entity
data class SerieResponse(
    val description: String,
    val endYear: Int,
    @PrimaryKey
    val id: Int,
    val modified: String,
    val rating: String,
    val resourceURI: String,
    val startYear: Int,
    @Embedded
    val thumbnail: Thumbnail,
    val title: String,
    val type: String
)