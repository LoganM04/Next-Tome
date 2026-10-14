package com.lmcoding.nexttome.data.mapper

import com.lmcoding.nexttome.data.remote.model.OpenLibraryBook
import com.lmcoding.nexttome.data.remote.network.BookTypeResolver
import com.lmcoding.nexttome.data.remote.network.VolumeParser
import com.lmcoding.nexttome.domain.model.BookInfo
import com.lmcoding.nexttome.domain.model.Isbn

internal fun OpenLibraryBook.toBookInfo(isbn: Isbn): BookInfo {
    val publisher = publishers.firstOrNull()?.name
    val parsed = VolumeParser.parse(title, subtitle)
    return BookInfo(
        isbn = isbn,
        title = listOfNotNull(title, subtitle).joinToString(" - "),
        authors = authors.map { it.name },
        publisher = publisher,
        publishedDate = publishDate,
        pageCount = numberOfPages,
        coverUrl = cover?.let { it.large ?: it.medium ?: it.small },
        type = BookTypeResolver.resolve(publisher, subjects.map { it.name }),
    )
}