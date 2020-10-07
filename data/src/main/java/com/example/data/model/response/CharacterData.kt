package com.example.data.model.response


import com.example.data.model.entitys.CharacterResponse
import com.google.gson.annotations.SerializedName

data class CharacterData(
    @SerializedName("count")
    val count: Int,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("results")
    val results: List<CharacterResponse>,
    @SerializedName("total")
    val total: Int
)