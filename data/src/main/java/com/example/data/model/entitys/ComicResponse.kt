package com.example.data.model.entitys


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.model.response.Creators
import com.example.data.model.response.Thumbnail

@Entity
data class ComicResponse(
    val description: String?,
    val diamondCode: String,
    val digitalId: Int,
    val ean: String,
    @Embedded
    val creators: Creators?,
    val format: String,
    @PrimaryKey
    val id: Int,
    val isbn: String,
    val issn: String,
    val issueNumber: Int,
    val modified: String,
    val pageCount: Int,
    val resourceURI: String,
    @Embedded
    val thumbnail: Thumbnail,
    val title: String,
    val upc: String,
    val variantDescription: String
)