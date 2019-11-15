package info.metadude.kotlin.library.c3media.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RecordingsResponse(

        val recordings: List<Recording>

)
