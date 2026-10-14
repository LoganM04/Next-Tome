package com.lmcoding.nexttome.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class OpenLibraryBook(
    val title: String,
    val subtitle: String? = null,
    val authors: List<OpenLibraryName> = emptyList(),
    val publishers: List<OpenLibraryName> = emptyList(),
    @SerialName("publish_date") val publishDate: String? = null,
    @SerialName("number_of_pages") val numberOfPages: Int? = null,
    val subjects: List<OpenLibraryName> = emptyList(),
    val cover: OpenLibraryCover? = null,
)

@Serializable
internal data class OpenLibraryName(val name: String)

@Serializable
internal data class OpenLibraryCover(
    val small: String? = null,
    val medium: String? = null,
    val large: String? = null,
)
