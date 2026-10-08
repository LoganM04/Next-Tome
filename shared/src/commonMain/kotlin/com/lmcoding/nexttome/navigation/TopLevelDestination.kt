package com.lmcoding.nexttome.navigation

import androidx.navigation3.runtime.NavKey
import nexttome.shared.generated.resources.Res
import nexttome.shared.generated.resources.ic_library
import nexttome.shared.generated.resources.ic_new_release
import nexttome.shared.generated.resources.ic_settings
import org.jetbrains.compose.resources.DrawableResource

enum class TopLevelDestination(
    val route: Route,
    val label: String,
    val icon: DrawableResource,
) {
    LIBRARY(Route.Library, "Ma biblio", Res.drawable.ic_library),
    NEW_RELEASES(Route.NewReleases, "Nouvelles sorties", Res.drawable.ic_new_release),
    SETTINGS(Route.Settings, "Paramètres", Res.drawable.ic_settings),
}

val TopLevelKeys: Set<NavKey> = TopLevelDestination.entries.map { it.route }.toSet()