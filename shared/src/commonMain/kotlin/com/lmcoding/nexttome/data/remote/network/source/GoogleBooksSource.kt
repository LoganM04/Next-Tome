package com.lmcoding.nexttome.data.remote.network.source

import com.lmcoding.nexttome.data.mapper.toBookInfo
import com.lmcoding.nexttome.data.remote.model.GoogleBookResponse
import com.lmcoding.nexttome.data.remote.util.NetworkError
import com.lmcoding.nexttome.data.remote.util.Result
import com.lmcoding.nexttome.data.remote.util.map
import com.lmcoding.nexttome.data.remote.util.safeCall
import com.lmcoding.nexttome.domain.model.BookInfo
import com.lmcoding.nexttome.domain.model.Isbn
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter


internal class GoogleBooksSource(
    private val client: HttpClient,
    private val apiKey: String? = null,
) : BookLookupSource {

    override suspend fun findByIsbn(isbn: Isbn): Result<BookInfo?, NetworkError> =
        safeCall<GoogleBookResponse> {
            client.get("https://www.googleapis.com/books/v1/volumes") {
                parameter("q", "isbn:${isbn.value}")
                apiKey?.let { parameter("key", it) }
            }
        }.map { response -> response.items.firstOrNull()?.volumeInfo?.toBookInfo(isbn) }
}