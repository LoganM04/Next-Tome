package com.lmcoding.nexttome.feature.library.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.lmcoding.nexttome.feature.library.LibraryScreen
import com.lmcoding.nexttome.navigation.Navigator
import com.lmcoding.nexttome.navigation.Route

fun EntryProviderScope<NavKey>.libraryEntry(navigator: Navigator){
    entry<Route.Library>{
        LibraryScreen(

        )
    }
}