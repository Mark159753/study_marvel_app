package com.example.data.model.response


import com.example.data.model.entitys.ComicResponse
import com.google.gson.annotations.SerializedName

data class ComicsData(
    @SerializedName("count")
    val count: Int,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("results")
    val results: List<ComicResponse>,
    @SerializedName("total")
    val total: Int
)