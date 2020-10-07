package com.example.data.model.response


import com.google.gson.annotations.SerializedName

data class Creators(
    @SerializedName("items")
    val items: List<Creator>?,
)