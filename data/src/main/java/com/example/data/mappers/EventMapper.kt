package com.example.data.mappers

import com.example.data.model.entitys.EventResponse
import com.example.domain.model.Event

class EventMapper:MarvelMapper<EventResponse, Event> {

    override fun transform(item: EventResponse): Event {
        return Event(
            item.description,
            item.end,
            item.id,
            item.modified,
            item.resourceURI,
            item.start,
            "${item.thumbnail.path}.${item.thumbnail.extension}",
            item.title
        )
    }
}