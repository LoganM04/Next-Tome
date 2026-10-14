package com.lmcoding.nexttome.data.remote.network.source

import com.lmcoding.nexttome.data.mapper.toBookInfo
import com.lmcoding.nexttome.data.remote.model.OpenLibraryBook
import com.lmcoding.nexttome.data.remote.util.NetworkError
import com.lmcoding.nexttome.domain.model.BookInfo
import com.lmcoding.nexttome.domain.model.Isbn
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.head
import io.ktor.client.request.parameter
import io.ktor.http.isSuccess
import kotlin.coroutines.cancellation.CancellationException
import com.lmcoding.nexttome.data.remote.util.Result
import com.lmcoding.nexttome.data.remote.util.map
import com.lmcoding.nexttome.data.remote.util.safeCall

internal class OpenLibrarySource(
    private val client: HttpClient,
) : BookLookupSource {

    override suspend fun findByIsbn(isbn: Isbn): Result<BookInfo?, NetworkError> {
        val key = "ISBN:${isbn.value}"
        return safeCall <Map<String, OpenLibraryBook>>{
            client.get("https://openlibrary.org/api/books") {
                parameter("bibkeys", key)
                parameter("format", "json")
                parameter("jscmd", "data")
            }
        }.map { response -> response[key]?.toBookInfo(isbn) }
    }
}