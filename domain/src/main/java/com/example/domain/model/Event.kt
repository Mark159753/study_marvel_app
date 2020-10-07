package com.example.domain.model

import java.io.Serializable

data class Event(
    val description: String,
    val end: String?,
    val id: Int,
    val modified: String,
    val resourceURI: String,
    val start: String?,
    val thumbnail: String,
    val title: String
):Serializable