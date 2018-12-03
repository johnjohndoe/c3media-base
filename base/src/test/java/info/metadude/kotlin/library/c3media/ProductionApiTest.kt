package info.metadude.kotlin.library.c3media

import info.metadude.kotlin.library.c3media.models.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.fail
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.io.IOException


@RunWith(JUnit4::class)
class ProductionApiTest {

    private val BASE_URL = "https://api.media.ccc.de"

    private val VALID_CONFERENCE_ID = 73
    private val VALID_CONFERENCE_ACRONYM = "34c3"

    private val VALID_EVENT_ID = 3763
    private val VALID_EVENT_GUID = "4cb7be14-bfbd-42a2-a556-9ef8e8bd6ba7"

    private val VALID_RECORDING_ID = 9967

    private val INVALID_CONFERENCE_ID = Int.MAX_VALUE
    private val INVALID_EVENT_ID = Int.MAX_VALUE
    private val INVALID_RECORDING_ID = Int.MAX_VALUE

    @Test
    fun `Validates a conferences response`() {
        val call = service.getConferences()
        try {
            val response = call.execute()
            if (response.isSuccessful) {
                val conferencesResponse = response.body()
                assertThat(conferencesResponse!!.conferences).isNotNull
                conferencesResponse.conferences?.let {
                    it.filterNotNull().forEach { assertListConference(it) }
                }
            } else {
                fail("getConferences() response is not successful.")
            }
        } catch (e: IOException) {
            fail("Should not throw {$e}")
        }
    }

    private fun assertListConference(conference: Conference) = with(conference) {
        assertThat(acronym).isNotNull()
        // assertThat(aspectRatio).isNotNull()
        //        .isNotEqualTo(AspectRatio.UNKNOWN)
        assertThat(updatedAt).isNotNull()
        // Currently three conferences return "eventLastReleasedAt": null.
        // assertThat(eventLastReleasedAt).isNotNull()
        assertThat(title).isNotNull()
        // assertThat(scheduleUrl).isNotNull()
        assertThat(slug).isNotNull()
        assertThat(webgenLocation).isNotNull()
        assertThat(logoUrl).isNotNull()
        assertThat(imagesUrl).isNotNull()
        assertThat(recordingsUrl).isNotNull()
        assertThat(url).isNotNull()
    }

    @Test
    fun `Validates a conference by id response`() {
        val call = service.getConference(VALID_CONFERENCE_ID)
        try {
            val response = call.execute()
            if (response.isSuccessful) {
                val conference = response.body()
                assertThat(conference!!).isNotNull()
                assertConference(conference)
            } else {
                fail("getConference() response is not successful.")
            }
        } catch (e: IOException) {
            fail("Should not throw {$e}")
        }
    }

    @Test
    fun `Validates a conference by acronym response`() {
        val call = service.getConference(VALID_CONFERENCE_ACRONYM)
        try {
            val response = call.execute()
            if (response.isSuccessful) {
                val conference = response.body()
                assertThat(conference).isNotNull
                assertConference(conference!!)
            } else {
                fail("getConference() response is not successful.")
            }
        } catch (e: IOException) {
            fail("Should not throw {$e}")
        }
    }

    private fun assertConference(conference: Conference) = with(conference) {
        assertThat(acronym).isNotNull()
        assertThat(aspectRatio).isNotNull()
                .isNotEqualTo(AspectRatio.UNKNOWN)
        assertThat(updatedAt).isNotNull()
        assertThat(eventLastReleasedAt).isNotNull()
        assertThat(title).isNotNull()
        // conference.scheduleUrl can be null
        assertThat(slug).isNotNull()
        assertThat(webgenLocation).isNotNull()
        assertThat(logoUrl).isNotNull()
        assertThat(imagesUrl).isNotNull()
        assertThat(recordingsUrl).isNotNull()
        assertThat(url).isNotNull()
        assertThat(events).isNotNull
        events?.let {
            it.filterNotNull().forEach { assertConferenceNestedEvent(it) }
        }
    }

    private fun assertConferenceNestedEvent(event: Event) = with(event) {
        assertThat(guid).isNotNull()
        assertThat(title).isNotNull()
        // assertThat(subtitle).isNotNull()
        assertThat(slug).isNotNull()
        // assertThat(link).isNotNull()
        // assertThat(description).isNotNull()
        assertOriginalLanguage(originalLanguage)
        assertThat(persons).isNotNull
        assertThat(tags).isNotNull
        // assertThat(date).isNotNull()
        assertThat(releaseDate).isNotNull()
        assertThat(updatedAt).isNotNull()
        assertThat(length).isNotNull()
        assertThat(thumbUrl).isNotNull()
        assertThat(posterUrl).isNotNull()
        assertThat(frontendLink).isNotNull()
        assertThat(url).isNotNull()
        assertThat(conferenceUrl).isNotNull()
    }

    @Test
    fun `Validates a conference error response`() {
        val call = service.getConference(INVALID_CONFERENCE_ID)
        try {
            val response = call.execute()
            assertThat(response.isSuccessful).isFalse()
        } catch (e: IOException) {
            fail("Should not throw {$e}")
        }
    }

    @Test
    fun `Validates an events response`() {
        val call = service.getEvents()
        try {
            val response = call.execute()
            if (response.isSuccessful) {
                val eventsResponse = response.body()
                assertThat(eventsResponse!!.events).isNotNull
                eventsResponse.events.forEach {
                    assertListEvent(it)
                }
            } else {
                fail("getEvents() response is not successful.")
            }
        } catch (e: IOException) {
            fail("Should not throw {$e}")
        }
    }

    @Test
    fun `Validates an events search response`() {
        val call = service.searchEvents("fnord")
        try {
            val response = call.execute()
            if (response.isSuccessful) {
                val eventsResponse = response.body()
                assertThat(eventsResponse!!.events).isNotNull
                eventsResponse.events.forEach {
                    assertListEvent(it)
                }
            } else {
                fail("getEvents() response is not successful.")
            }
        } catch (e: IOException) {
            fail("Should not throw {$e}")
        }
    }

    private fun assertListEvent(event: Event) = with(event) {
        // assertThat(id).isNotNull()
        assertThat(guid).isNotNull()
        // assertThat(posterFilename).isNotNull()
        // assertThat(conferenceId).isNotNull()
        assertThat(updatedAt).isNotNull()
        assertThat(title).isNotNull()
        // assertThat(thumbFilename).isNotNull()
        // assertThat(date).isNotNull()
        // assertThat(description).isNotNull()
        // assertThat(link).isNotNull()
        assertThat(persons).isNotNull
        assertThat(slug).isNotNull()
        // assertThat(subtitle).isNotNull()
        assertThat(tags).isNotNull
        assertThat(releaseDate).isNotNull()
        assertThat(promoted).isNotNull()
        assertThat(viewCount).isNotNull()
        assertThat(duration).isNotNull()
        // assertThat(downloadedRecordingsCount).isNotNull()
        assertOriginalLanguage(originalLanguage)
        assertThat(related).isNotNull
        related!!.forEach(::assertRelatedEvent)
    }

    private fun assertRelatedEvent(relatedEvent: RelatedEvent) {
        assertThat(relatedEvent.eventId).isNotNull()
        assertThat(relatedEvent.eventGuid).isNotNull()
        assertThat(relatedEvent.weight).isNotNull()
    }

    @Test
    fun `Validates an event by id response`() {
        val call = service.getEvent(VALID_EVENT_ID)
        try {
            val response = call.execute()
            if (response.isSuccessful) {
                val event = response.body()
                assertThat(event!!).isNotNull()
                assertEvent(event)
            } else {
                fail("getEvent() response is not successful.")
            }
        } catch (e: IOException) {
            fail("Should not throw {$e}")
        }
    }

    @Test
    fun `Validates an event by guid response`() {
        val call = service.getEvent(VALID_EVENT_GUID)
        try {
            val response = call.execute()
            if (response.isSuccessful) {
                val event = response.body()
                assertThat(event).isNotNull
                assertEvent(event!!)
            } else {
                fail("getEvent() response is not successful.")
            }
        } catch (e: IOException) {
            fail("Should not throw {$e}")
        }
    }

    private fun assertEvent(event: Event) = with(event) {
        assertThat(guid).isNotNull()
        assertThat(title).isNotNull()
        // assertThat(subtitle).isNotNull()
        assertThat(slug).isNotNull()
        // assertThat(link).isNotNull()
        // assertThat(description).isNotNull()
        assertOriginalLanguage(originalLanguage)
        assertThat(persons).isNotNull
        assertThat(tags).isNotNull
        // assertThat(date).isNotNull()
        assertThat(releaseDate).isNotNull()
        assertThat(updatedAt).isNotNull()
        assertThat(length).isNotNull()
        assertThat(thumbUrl).isNotNull()
        assertThat(posterUrl).isNotNull()
        assertThat(frontendLink).isNotNull()
        assertThat(url).isNotNull()
        assertThat(conferenceUrl).isNotNull()
        // assertThat(recordings).isNotNull
        recordings?.let {
            it.filterNotNull().forEach {
                assertEventNestedRecording(it)
            }
        }
    }

    private fun assertEventNestedRecording(recording: Recording) = with(recording) {
        assertThat(size).isNotNull()
        assertThat(length).isNotNull()
        assertThat(mimeType).isNotNull()
        assertThat(language)
                .isNotNull
                .isNotEmpty
                .doesNotContain(Language.UNKNOWN)
        assertThat(filename).isNotNull()
        assertThat(state).isNotNull()
        assertThat(folder).isNotNull()
        assertThat(highQuality).isNotNull()
        assertThat(width).isNotNull()
        assertThat(height).isNotNull()
        assertThat(updatedAt).isNotNull()
        assertThat(recordingUrl).isNotNull()
        assertThat(url).isNotNull()
        assertThat(eventUrl).isNotNull()
        assertThat(conferenceUrl).isNotNull()
    }

    @Test
    fun `Validates an event error response`() {
        val call = service.getEvent(INVALID_EVENT_ID)
        try {
            val response = call.execute()
            assertThat(response.isSuccessful).isFalse()
        } catch (e: IOException) {
            fail("Should not throw {$e}")
        }
    }

    @Test
    fun `Validates a recordings response`() {
        val call = service.getRecordings()
        try {
            val response = call.execute()
            if (response.isSuccessful) {
                val recordingsResponse = response.body()
                assertThat(recordingsResponse!!.recordings).isNotNull
                recordingsResponse.recordings.forEach {
                    assertBaseRecording(it)
                }
            } else {
                fail("getRecordings() response is not successful.")
            }
        } catch (e: IOException) {
            fail("Should not throw {$e}")
        }
    }

    private fun assertBaseRecording(recording: Recording) = with(recording) {
        // assertThat(id).isNotNull()
        assertThat(size).isNotNull()
        assertThat(length).isNotNull()
        assertThat(mimeType).isNotNull()
                .isNotEqualTo(MimeType.UNKNOWN)
        assertThat(eventId).isNotNull()
        // assertThat(createdAt).isNotNull()
        assertThat(updatedAt).isNotNull()
        assertThat(filename).isNotNull()
        assertThat(state).isNotNull()
        assertThat(folder).isNotNull()
        // assertThat(width).isNotNull()
        // assertThat(height).isNotNull()
        assertThat(language)
                .isNotNull
                .isNotEmpty
                .doesNotContain(Language.UNKNOWN)
        assertThat(highQuality).isNotNull()
        assertThat(html5).isNotNull()
    }

    @Test
    fun `Validates a recording response`() {
        val call = service.getRecording(VALID_RECORDING_ID)
        try {
            val response = call.execute()
            if (response.isSuccessful) {
                val recording = response.body()
                assertThat(recording!!).isNotNull()
                assertSingleRecording(recording)
            } else {
                fail("getRecording() response is not successful.")
            }
        } catch (e: IOException) {
            fail("Should not throw {$e}")
        }
    }

    private fun assertSingleRecording(recording: Recording) = with(recording) {
        // assertThat(size).isNotNull()
        assertThat(length).isNotNull()
        assertThat(mimeType).isNotNull()
                .isNotEqualTo(MimeType.UNKNOWN)
        assertThat(language)
                .isNotNull
                .isNotEmpty
                .doesNotContain(Language.UNKNOWN)
        assertThat(filename).isNotNull()
        assertThat(state).isNotNull()
        assertThat(folder).isNotNull()
        assertThat(highQuality).isNotNull()
        assertThat(width).isNotNull()
        assertThat(height).isNotNull()
        assertThat(updatedAt).isNotNull()
        assertThat(recordingUrl).isNotNull()
        assertThat(url).isNotNull()
        assertThat(eventUrl).isNotNull()
        assertThat(conferenceUrl).isNotNull()
    }

    @Test
    fun `Validates a recording error response`() {
        val call = service.getRecording(INVALID_RECORDING_ID)
        try {
            val response = call.execute()
            assertThat(response.isSuccessful).isFalse()
        } catch (e: IOException) {
            fail("Should not throw {$e}")
        }
    }

    private fun assertOriginalLanguage(originalLanguage: List<Language>) {
        assertThat(originalLanguage)
                .isNotNull
                .isNotEmpty
                .doesNotContain(Language.UNKNOWN)
    }

    private val service: C3MediaService by lazy {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.NONE
        val okHttpClient = OkHttpClient.Builder()
                .addNetworkInterceptor(interceptor)
                .build()
        ApiModule.provideC3MediaService(BASE_URL, okHttpClient)
    }

}
