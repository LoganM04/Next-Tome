package com.lmcoding.nexttome.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class GoogleBookResponse(
    val totalItems: Int = 0,
    val items: List<GoogleVolume> = emptyList(),
)

@Serializable
data class GoogleVolume(
    val volumeInfo: GoogleVolumeInfo,
)

@Serializable
data class GoogleVolumeInfo(
    val title: String,
    val subtitle: String? = null,
    val authors: List<String> = emptyList(),
    val publisher: String? = null,
    val publishedDate: String? = null,
    val pageCount: Int? = null,
    val categories: List<String> = emptyList(),
    val imageLinks: GoogleImageLinks? = null,
)

@Serializable
data class GoogleImageLinks(
    val thumbnail: String? = null,
    val smallThumbnail: String? = null,
)