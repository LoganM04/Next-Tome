package com.lmcoding.nexttome.data.mapper

import com.lmcoding.nexttome.data.remote.model.GoogleVolumeInfo
import com.lmcoding.nexttome.data.remote.network.BookTypeResolver
import com.lmcoding.nexttome.data.remote.network.VolumeParser
import com.lmcoding.nexttome.domain.model.BookInfo
import com.lmcoding.nexttome.domain.model.Isbn


internal fun GoogleVolumeInfo.toBookInfo(isbn: Isbn): BookInfo {
    val parsed = VolumeParser.parse(title, subtitle)
    return BookInfo(
        isbn = isbn,
        title = listOfNotNull(title, subtitle).joinToString(" - "),
        authors = authors,
        publisher = publisher,
        publishedDate = publishedDate,
        pageCount = pageCount,
        coverUrl = null,
        type = BookTypeResolver.resolve(publisher, categories),
    )
}