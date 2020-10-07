package com.example.data.mappers

interface MarvelMapper<FROM, TO> {

    fun transform(item:FROM):TO
}