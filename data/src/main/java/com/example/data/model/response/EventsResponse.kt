package com.example.data.model.response


import com.google.gson.annotations.SerializedName

data class EventsResponse(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val data: EventsData,
    @SerializedName("status")
    val status: String
)