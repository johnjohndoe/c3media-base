package info.metadude.kotlin.library.c3media.models

import com.squareup.moshi.Json

data class Metadata(

        val related: Map<String, Int>? = null,
        @Json(name = "remote_id")
        val remoteId: Int? = null

)
