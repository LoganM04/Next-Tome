package com.lmcoding.nexttome.data.remote.network

import com.lmcoding.nexttome.feature.library.domain.BookType

internal object BookTypeResolver {
    private val mangaPublishers = listOf(
        "glénat manga", "glenat manga", "kana", "pika", "ki-oon", "kurokawa",
        "tonkam", "kazé", "kaze", "akata", "meian", "noeve",
    )
    private val comicsPublishers = listOf(
        "urban comics", "panini comics", "marvel", "dc comics", "image comics",
    )
    private val bdPublishers = listOf(
        "dupuis", "dargaud", "casterman", "le lombard", "lombard", "soleil", "bamboo",
        "delcourt", "glénat", "glenat", "futuropolis", "rue de sèvres",
    )

    fun resolve(publisher: String?, categories: List<String>?): BookType {
        val pub = publisher.orEmpty().lowercase()
        val cats = categories.orEmpty().joinToString(" ").lowercase()

        return when {
            mangaPublishers.any { it in pub } || "manga" in cats -> BookType.MANGA
            comicsPublishers.any { it in pub } -> BookType.COMICS
            bdPublishers.any { it in pub } -> BookType.BD
            "comics" in cats || "graphic novel" in cats -> BookType.BD
            "fiction" in cats -> BookType.ROMAN
            else -> BookType.AUTRE
        }
    }
}