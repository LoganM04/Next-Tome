package com.lmcoding.nexttome.di

import com.lmcoding.nexttome.data.remote.network.HttpClientFactory
import com.lmcoding.nexttome.data.remote.network.platformHttpEngine
import com.lmcoding.nexttome.data.remote.network.source.GoogleBooksSource
import com.lmcoding.nexttome.data.remote.network.source.OpenLibrarySource
import com.lmcoding.nexttome.data.repository.BookLookupRepositoryImpl
import com.lmcoding.nexttome.domain.repository.BookLookupRepository
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val networkModule = module {
    single { HttpClientFactory.create(platformHttpEngine()) }
    single { GoogleBooksSource(client = get()) }
    single { OpenLibrarySource(client = get()) }
}

val dataModule = module {
    single<BookLookupRepository> {
        BookLookupRepositoryImpl(
            sources = listOf(get<GoogleBooksSource>(), get<OpenLibrarySource>()),
            openLibrarySource = get(),
        )
    }
}

val appModules = listOf(networkModule, dataModule)