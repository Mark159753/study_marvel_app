package com.example.data.mappers

import com.example.data.model.entitys.ComicResponse
import com.example.data.model.response.ComicsResponse
import com.example.data.model.response.Creators
import com.example.domain.model.Comics
import com.example.domain.model.ThumbnailM

class ComicsMapper:MarvelMapper<ComicResponse, Comics> {

    override fun transform(item: ComicResponse): Comics {
        return Comics(
            item.description,
            item.diamondCode,
            item.digitalId,
            creatorToString(item.creators),
            item.ean,
            item.format,
            item.id,
            item.isbn,
            item.issn,
            item.issueNumber,
            item.modified,
            item.pageCount,
            item.resourceURI,
            ThumbnailM(item.thumbnail.extension, item.thumbnail.path),
            item.title,
            item.upc,
            item.variantDescription
        )
    }

    private fun creatorToString(creators: Creators?):String?{
        return if (creators?.items != null && creators.items.isNotEmpty())
            creators.items[0].name
        else
            null
    }
}