package com.example.data.mappers

import com.example.data.model.entitys.CharacterResponse
import com.example.data.model.response.Thumbnail
import com.example.domain.model.Character
import com.example.domain.model.ThumbnailM

class CharacterMapper:MarvelMapper<CharacterResponse, Character> {

    override fun transform(item: CharacterResponse): Character {
        return Character(
            item.description,
            item.id,
            item.modified,
            item.name,
            item.resourceURI,
            ThumbnailM(item.thumbnail.extension, item.thumbnail.path)
        )
    }

}