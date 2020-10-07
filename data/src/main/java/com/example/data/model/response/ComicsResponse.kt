package com.example.data.model.response


import com.google.gson.annotations.SerializedName

data class ComicsResponse(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val data: ComicsData,
    @SerializedName("status")
    val status: String
)