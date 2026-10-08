package com.lmcoding.nexttome.navigation

import androidx.navigation3.runtime.NavKey
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.Serializable
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Serializable
sealed interface Route : NavKey {
    @Serializable data object Library : Route
    @Serializable data object NewReleases : Route
    @Serializable data object Settings : Route
    @Serializable data class SeriesDetail(val seriesId: Long) : Route
    @Serializable data object AddBook : Route
}

val navConfig = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclass(Route.Library::class, Route.Library.serializer())
            subclass(Route.NewReleases::class, Route.NewReleases.serializer())
            subclass(Route.Settings::class, Route.Settings.serializer())
            subclass(Route.SeriesDetail::class, Route.SeriesDetail.serializer())
            subclass(Route.AddBook::class, Route.AddBook.serializer())
        }
    }
}