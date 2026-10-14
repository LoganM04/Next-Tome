package com.lmcoding.nexttome.feature.add.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.lmcoding.nexttome.feature.add.AddBookScreen
import com.lmcoding.nexttome.navigation.Navigator
import com.lmcoding.nexttome.navigation.Route

fun EntryProviderScope<NavKey>.addBookEntry(navigator: Navigator){
    entry<Route.AddBook>{
        AddBookScreen(onBack = navigator::goBack)
    }
}
