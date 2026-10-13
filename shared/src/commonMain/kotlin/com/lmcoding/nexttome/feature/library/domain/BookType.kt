package com.lmcoding.nexttome.feature.library.domain
enum class BookType { MANGA, BD, COMICS, ROMAN, AUTRE }

val BookType.label
    get() = when(this){
        BookType.MANGA -> "Manga"
        BookType.BD -> "BD"
        BookType.COMICS -> "Comics"
        BookType.ROMAN -> "Roman"
        BookType.AUTRE -> "Autre"
    }
