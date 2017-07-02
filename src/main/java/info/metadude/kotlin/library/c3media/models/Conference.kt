package info.metadude.kotlin.library.c3media.models

import com.squareup.moshi.Json
import org.threeten.bp.OffsetDateTime

data class Conference(

        val acronym: String = "",
        @Json(name = "aspect_ratio")
        val aspectRatio: AspectRatio = AspectRatio.UNKNOWN,
        val events: List<Event?> = emptyList(),
        @Json(name = "images_url")
        val imagesUrl: String = "",
        @Json(name = "logo_url")
        val logoUrl: String = "",
        @Json(name = "recordings_url")
        val recordingsUrl: String = "",
        @Json(name = "schedule_url")
        val scheduleUrl: String = "",
        val slug: String = "",
        val title: String = "",
        @Json(name = "updated_at")
        val updatedAt: OffsetDateTime? = null,
        val url: String = "",
        @Json(name = "webgen_location")
        val webgenLocation: String = ""

)
