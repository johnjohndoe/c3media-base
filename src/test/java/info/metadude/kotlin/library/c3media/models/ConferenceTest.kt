package info.metadude.kotlin.library.c3media.models

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import info.metadude.kotlin.library.c3media.adapters.AspectRatioAdapter
import info.metadude.kotlin.library.c3media.adapters.OffsetDateTimeAdapter
import org.assertj.core.api.Assertions.assertThat
import org.intellij.lang.annotations.Language
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter


@RunWith(JUnit4::class)
class ConferenceTest {

    private val dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME!!

    val adapter: JsonAdapter<Conference> by lazy {
        val moshi = Moshi.Builder()
                .add(OffsetDateTimeAdapter())
                .add(AspectRatioAdapter())
                .build()
        moshi.adapter<Conference>(Conference::class.java)
    }

    @Test
    fun `Converts a conference JSON with values to a conference object`() {
        val conference = adapter.fromJson(completeConferenceJson)
        assertThat(conference).isEqualToComparingFieldByFieldRecursively(completeConference())
    }

    @Language("JSON")
    private val completeConferenceJson = "{\n  " +
            "\"acronym\": \"ds2015\",\n  " +
            "\"aspect_ratio\": \"16:9\",\n  " +
            "\"images_url\": \"https://static.media.ccc.de/media/events/datenspuren/2015\",\n  " +
            "\"logo_url\": \"https://static.media.ccc.de/media/events/datenspuren/2015/ds2015.png\",\n  " +
            "\"recordings_url\": \"http://cdn.media.ccc.de/events/datenspuren/2015\",\n  " +
            "\"schedule_url\": \"http://datenspuren.de/2015/fahrplan/schedule.xml\",\n  " +
            "\"slug\": \"conferences/datenspuren/2015\",\n  " +
            "\"title\": \"Datenspuren 2015\",\n  " +
            "\"updated_at\": \"2016-12-14T13:17:39.496+01:00\",\n  " +
            "\"url\": \"https://api.media.ccc.de/public/conferences/73\",\n  " +
            "\"webgen_location\": \"conferences/datenspuren/2015\"\n" +
            "}"

    fun completeConference(): Conference {
        val updatedAt = OffsetDateTime.parse("2016-12-14T13:17:39.496+01:00", dateTimeFormatter)
        return Conference(
                acronym = "ds2015",
                aspectRatio = AspectRatio._16_X_9,
                events = emptyList(),
                imagesUrl = "https://static.media.ccc.de/media/events/datenspuren/2015",
                logoUrl = "https://static.media.ccc.de/media/events/datenspuren/2015/ds2015.png",
                recordingsUrl = "http://cdn.media.ccc.de/events/datenspuren/2015",
                scheduleUrl = "http://datenspuren.de/2015/fahrplan/schedule.xml",
                slug = "conferences/datenspuren/2015",
                title = "Datenspuren 2015",
                updatedAt = updatedAt,
                url = "https://api.media.ccc.de/public/conferences/73",
                webgenLocation = "conferences/datenspuren/2015"
        )
    }

    @Test
    fun `Converts a conference JSON without values to a conference object`() {
        val conference = adapter.fromJson(valueLessConferenceJson)
        assertThat(conference).isEqualToComparingFieldByFieldRecursively(valueLessConference())
    }

    @Language("JSON")
    private val valueLessConferenceJson = "{\n  " +
            "\"acronym\": \"\",\n  " +
            "\"aspect_ratio\": \"\",\n  " +
            "\"images_url\": \"\",\n  " +
            "\"logo_url\": \"\",\n  " +
            "\"recordings_url\": \"\",\n  " +
            "\"schedule_url\": \"\",\n  " +
            "\"slug\": \"\",\n  " +
            "\"title\": \"\",\n  " +
            "\"updated_at\": \"\",\n  " +
            "\"url\": \"\",\n  " +
            "\"webgen_location\": \"\"\n" +
            "}"

    fun valueLessConference(): Conference {
        return Conference(
                acronym = "",
                aspectRatio = AspectRatio.UNKNOWN,
                events = emptyList(),
                imagesUrl = "",
                logoUrl = "",
                recordingsUrl = "",
                scheduleUrl = "",
                slug = "",
                title = "",
                updatedAt = null,
                url = "",
                webgenLocation = ""
        )
    }

    @Test
    fun `Converts an empty conference JSON to a conference object`() {
        val conference = adapter.fromJson(emptyConferenceJson)
        assertThat(conference).isEqualToComparingFieldByFieldRecursively(emptyConference())
    }

    @Language("JSON")
    private val emptyConferenceJson = "{}"

    fun emptyConference(): Conference {
        return Conference(
                acronym = "",
                aspectRatio = AspectRatio.UNKNOWN,
                events = emptyList(),
                imagesUrl = "",
                logoUrl = "",
                recordingsUrl = "",
                scheduleUrl = "",
                slug = "",
                title = "",
                updatedAt = null,
                url = "",
                webgenLocation = ""
        )
    }

}
