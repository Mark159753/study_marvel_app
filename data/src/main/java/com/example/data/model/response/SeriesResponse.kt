package com.example.data.model.response


import com.google.gson.annotations.SerializedName

data class SeriesResponse(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val data: SeriesData,
    @SerializedName("status")
    val status: String
)