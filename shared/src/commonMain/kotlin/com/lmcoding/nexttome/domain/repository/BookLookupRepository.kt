package com.lmcoding.nexttome.domain.repository

import com.lmcoding.nexttome.data.remote.util.Result
import com.lmcoding.nexttome.domain.error.LookupError
import com.lmcoding.nexttome.domain.model.BookInfo
import com.lmcoding.nexttome.domain.model.Isbn

interface BookLookupRepository {

    suspend fun findByIsbn(rawIsbn : Isbn) : Result<BookInfo, LookupError>
}