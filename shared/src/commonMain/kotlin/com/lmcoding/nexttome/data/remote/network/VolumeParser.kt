package com.lmcoding.nexttome.data.remote.network

internal object VolumeParser {
    private val explicitMarker = Regex(
        """^(.*?)[\s,.:\-–]*\b(?:tome|t\.?|vol\.?|volume|n°|no\.?)\s*(\d{1,4})\b.*$""",
        RegexOption.IGNORE_CASE,
    )
    private val hashMarker = Regex("""^(.*?)\s*#\s*(\d{1,4})\b.*$""")

    // "One Piece 45" : moins fiable ("Fahrenheit 451"...), donc limité aux petits nombres
    private val trailingNumber = Regex("""^(.*\D)[\s\-–:]+(\d{1,3})$""")

    fun parse(title: String, subtitle: String? = null): ParsedVolume {
        val full = listOfNotNull(title, subtitle).joinToString(" - ").trim()

        for (regex in listOf(explicitMarker, hashMarker)) {
            regex.matchEntire(full)?.let { match ->
                val series = match.groupValues[1].cleanSeries()
                val number = match.groupValues[2].toIntOrNull()
                if (series.isNotBlank()) return ParsedVolume(series, number)
            }
        }

        trailingNumber.matchEntire(title.trim())?.let { match ->
            val number = match.groupValues[2].toInt()
            val series = match.groupValues[1].cleanSeries()
            if (series.isNotBlank() && number in 1..200) return ParsedVolume(series, number)
        }

        return ParsedVolume(title.trim(), null)
    }

    private fun String.cleanSeries() = trim().trimEnd('-', '–', ':', ',', '.').trim()
}