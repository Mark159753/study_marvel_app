package com.example.domain.model

import java.io.Serializable

data class Comics(
    val description: String?,
    val diamondCode: String,
    val digitalId: Int,
    val creators: String?,
    val ean: String,
    val format: String,
    val id: Int,
    val isbn: String,
    val issn: String,
    val issueNumber: Int,
    val modified: String,
    val pageCount: Int,
    val resourceURI: String,
    val thumbnail: ThumbnailM,
    val title: String,
    val upc: String,
    val variantDescription: String
):Serializable