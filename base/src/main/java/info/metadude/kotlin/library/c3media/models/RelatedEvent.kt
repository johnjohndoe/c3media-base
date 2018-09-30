package info.metadude.kotlin.library.c3media.models

import com.squareup.moshi.Json

data class RelatedEvent(

        @Json(name = "event_id")
        val eventId: Int? = null,

        @Json(name = "event_guid")
        val eventGuid: String? = null,

        val weight: Int? = null

)