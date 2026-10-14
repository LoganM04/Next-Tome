package com.lmcoding.nexttome.domain.model

import com.lmcoding.nexttome.feature.library.domain.BookType

data class BookInfo(
    val isbn : Isbn,
    val title : String,
    val authors: List<String> = emptyList(),
    val publisher: String? = null,
    val publishedDate: String? = null,
    val pageCount: Int? = null,
    val coverUrl: String? = null,
    val type: BookType = BookType.AUTRE,
)
