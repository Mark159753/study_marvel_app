package com.example.domain.model

import java.io.Serializable

data class Character(
    val description: String,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val thumbnail: ThumbnailM
):Serializable