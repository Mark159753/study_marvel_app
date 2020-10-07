package com.example.domain.model
import java.io.Serializable

data class Series(
    val description: String,
    val endYear: Int,
    val id: Int,
    val modified: String,
    val next: String,
    val previous: String,
    val rating: String,
    val resourceURI: String,
    val startYear: Int,
    val thumbnail: String,
    val title: String,
    val type: String
):Serializable