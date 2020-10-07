package com.example.data.model.response


import com.example.data.model.entitys.EventResponse
import com.google.gson.annotations.SerializedName

data class EventsData(
    @SerializedName("count")
    val count: Int,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("results")
    val results: List<EventResponse>,
    @SerializedName("total")
    val total: Int
)