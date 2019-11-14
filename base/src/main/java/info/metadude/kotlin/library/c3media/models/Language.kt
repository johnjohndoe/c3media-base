package info.metadude.kotlin.library.c3media.models

@Suppress("unused")
enum class Language(

        val frabCode: String,
        val isoCode_639_1: String,
        val englishName: String) {

    // ISO 639-1 codes
    // https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes

    DE("deu", "de", "German"),
    DE_CH("gsw", "de-ch", "Swiss German"),
    EN("eng", "en", "English"),
    ES("spa", "es", "Spanish"),
    FR("fra", "fr", "French"),
    JA("jpn", "ja", "Japanese"),
    RU("rus", "ru", "Russian"),

    // Original (different presenters using not the same languages,
    // text not translated)'] # use only for subtitles and not for
    // audio or video recordings!
    ORIG("orig", "", "Original"),
    // Fallback
    UNKNOWN("unknown", "unknown", "Unknown Frab code");

    override fun toString() = "$frabCode:$isoCode_639_1"

    companion object {

        fun toLanguage(frabCode: String) = when (frabCode) {
            ORIG.frabCode -> ORIG
            DE.frabCode -> DE
            DE_CH.frabCode -> DE_CH
            EN.frabCode -> EN
            ES.frabCode -> ES
            FR.frabCode -> FR
            JA.frabCode -> JA
            RU.frabCode -> RU
            else -> UNKNOWN
        }

        fun toFrabCode(language: Language) = when (language) {
            ORIG -> ORIG.frabCode
            DE -> DE.frabCode
            DE_CH -> DE_CH.frabCode
            EN -> EN.frabCode
            ES -> ES.frabCode
            FR -> FR.frabCode
            JA -> JA.frabCode
            RU -> RU.frabCode
            else -> null
        }

    }

}
