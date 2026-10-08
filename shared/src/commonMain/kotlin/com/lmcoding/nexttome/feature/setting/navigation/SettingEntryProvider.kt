package com.lmcoding.nexttome.feature.setting.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.lmcoding.nexttome.feature.setting.SettingScreen
import com.lmcoding.nexttome.navigation.Navigator
import com.lmcoding.nexttome.navigation.Route

fun EntryProviderScope<NavKey>.settingEntry(navigator: Navigator){
    entry <Route.Settings>{
        SettingScreen()
    }
}