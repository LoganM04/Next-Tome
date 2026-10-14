package com.lmcoding.nexttome.data.remote.network.source

import com.lmcoding.nexttome.data.remote.util.NetworkError
import com.lmcoding.nexttome.domain.model.BookInfo
import com.lmcoding.nexttome.domain.model.Isbn
import com.lmcoding.nexttome.data.remote.util.Result

internal interface BookLookupSource {
    suspend fun findByIsbn(isbn: Isbn): Result<BookInfo?, NetworkError>
}