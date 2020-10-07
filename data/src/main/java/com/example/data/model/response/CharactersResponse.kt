package com.example.data.model.response


import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    val code: Int,
    @SerializedName("data")
    val data: CharacterData,
    @SerializedName("status")
    val status: String
)