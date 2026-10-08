package com.lmcoding.nexttome.feature.newRelease.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import com.lmcoding.nexttome.feature.newRelease.NewReleaseScreen
import com.lmcoding.nexttome.navigation.Navigator
import com.lmcoding.nexttome.navigation.Route

fun EntryProviderScope<NavKey>.newReleaseEntry(navigator: Navigator){
    entry<Route.NewReleases> {
        NewReleaseScreen()
    }
}