package com.lmcoding.nexttome.data.repository

import com.lmcoding.nexttome.data.mapper.toLookupError
import com.lmcoding.nexttome.data.remote.network.source.BookLookupSource
import com.lmcoding.nexttome.data.remote.network.source.OpenLibrarySource
import com.lmcoding.nexttome.domain.error.LookupError
import com.lmcoding.nexttome.domain.model.BookInfo
import com.lmcoding.nexttome.domain.model.Isbn
import com.lmcoding.nexttome.domain.repository.BookLookupRepository
import com.lmcoding.nexttome.data.remote.util.Result

internal class BookLookupRepositoryImpl(
    private val sources : List<BookLookupSource>,
    private val openLibrarySource: OpenLibrarySource
) : BookLookupRepository{
    override suspend fun findByIsbn(rawIsbn: Isbn): Result<BookInfo, LookupError> {
        var failure: LookupError? = null

        for (source in sources) {
            when (val result = source.findByIsbn(rawIsbn)) {
                is Result.Success -> result.data?.let { book ->
                    return Result.Success(book)
                }
                is Result.Error -> {
                    val error = result.error.toLookupError()
                    if (failure == null || error == LookupError.NO_INTERNET) failure = error
                }
            }
        }

        return Result.Error(failure ?: LookupError.NOT_FOUND)
    }

}