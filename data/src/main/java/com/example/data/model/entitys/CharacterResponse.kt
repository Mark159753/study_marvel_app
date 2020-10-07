package com.example.data.model.entitys


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.model.response.Thumbnail

@Entity
data class CharacterResponse(
    val description: String,
    @PrimaryKey
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    @Embedded
    val thumbnail: Thumbnail
)