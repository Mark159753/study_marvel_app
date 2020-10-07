package com.example.data.model.response


import com.example.data.model.entitys.SerieResponse
import com.google.gson.annotations.SerializedName

data class SeriesData(
    @SerializedName("count")
    val count: Int,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("results")
    val results: List<SerieResponse>,
    @SerializedName("total")
    val total: Int
)