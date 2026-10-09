package com.lmcoding.nexttome.feature.library

import com.lmcoding.nexttome.feature.library.domain.BookType

data class LibraryState(
    val filters : List<BookType>
)