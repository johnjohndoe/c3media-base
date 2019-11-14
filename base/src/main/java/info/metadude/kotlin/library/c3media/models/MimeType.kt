package info.metadude.kotlin.library.c3media.models

enum class MimeType(val text: String) {

    MP3("audio/mpeg"),
    OPUS("audio/opus"),
    MP4("video/mp4"),
    WEBM("video/webm"),
    UNKNOWN("Unknown mime/type");

    override fun toString() = text

    companion object {

        fun toMimeType(text: String?) = when (text) {
            MP3.text -> MP3
            OPUS.text -> OPUS
            MP4.text -> MP4
            WEBM.text -> WEBM
            else -> UNKNOWN
        }

        fun toText(mimeType: MimeType) = when (mimeType) {
            MP3 -> MP3.text
            OPUS -> OPUS.text
            MP4 -> MP4.text
            WEBM -> WEBM.text
            UNKNOWN -> null
        }

    }

}
