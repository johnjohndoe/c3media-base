package info.metadude.kotlin.library.c3media.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import org.threeten.bp.LocalDate
import org.threeten.bp.OffsetDateTime

@JsonClass(generateAdapter = true)
data class Conference(

        val acronym: String,
        @Json(name = "aspect_ratio")
        val aspectRatio: AspectRatio? = null,
        @Json(name = "event_last_released_at")
        val eventLastReleasedAt: LocalDate? = null,
        val events: List<Event?>? = null,
        @Json(name = "images_url")
        val imagesUrl: String? = null,
        @Json(name = "logo_url")
        val logoUrl: String? = null,
        @Json(name = "recordings_url")
        val recordingsUrl: String? = null,
        @Json(name = "schedule_url")
        val scheduleUrl: String? = null,
        val slug: String,
        val title: String? = null,
        @Json(name = "updated_at")
        val updatedAt: OffsetDateTime? = null,
        val url: String? = null,
        @Json(name = "webgen_location")
        val webgenLocation: String? = null

)
