package info.metadude.kotlin.library.c3media.models

enum class AspectRatio(val text: String) {

    _16_X_9("16:9"),
    _4_X_3("4:3"),
    UNKNOWN("Unknown aspect ratio");

    override fun toString() = text

    companion object {

        fun toAspectRatio(text: String?) = when (text) {
            _16_X_9.text -> _16_X_9
            _4_X_3.text -> _4_X_3
            else -> UNKNOWN
        }

        fun toText(aspectRatio: AspectRatio) = when (aspectRatio) {
            _16_X_9 -> _16_X_9.text
            _4_X_3 -> _4_X_3.text
            UNKNOWN -> null
        }

    }

}
