package com.lmcoding.nexttome

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.lmcoding.nexttome.annotation.ThemePreviews
import com.lmcoding.nexttome.feature.library.navigation.libraryEntry
import com.lmcoding.nexttome.feature.newRelease.navigation.newReleaseEntry
import com.lmcoding.nexttome.feature.setting.navigation.settingEntry
import com.lmcoding.nexttome.navigation.Navigator
import com.lmcoding.nexttome.navigation.Route
import com.lmcoding.nexttome.navigation.TopLevelKeys
import com.lmcoding.nexttome.navigation.navConfig
import com.lmcoding.nexttome.navigation.rememberNavigationState
import com.lmcoding.nexttome.navigation.toEntries
import com.lmcoding.nexttome.ui.LocalScaffoldPadding
import com.lmcoding.nexttome.ui.components.AppNavigationBar
import com.lmcoding.nexttome.ui.theme.AppTheme

@Composable
fun App() {
    AppTheme {
        val navigationState = rememberNavigationState(
            startKey = Route.Library,
            topLevelKeys = TopLevelKeys,
            configuration = navConfig,
        )
        val navigator = remember(navigationState) { Navigator(navigationState) }

        val showBottomBar = navigationState.currentKey != Route.AddBook

        Scaffold(
            bottomBar = {
                AppNavigationBar(
                    isVisible = showBottomBar,
                    currentTopLevelKey = navigationState.currentTopLevelKey,
                    onTabClick = navigator::navigate
                )
            }
        ){ padding ->
            CompositionLocalProvider(LocalScaffoldPadding provides padding){
                AppContent(navigator)
            }
        }
    }
}

@Composable
private fun AppContent(navigator: Navigator){
    val entryProvider: (NavKey) -> NavEntry<NavKey> =
        entryProvider {
            libraryEntry(navigator = navigator)
            newReleaseEntry(navigator = navigator)
            settingEntry(navigator = navigator)
        }

    NavDisplay(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(
                WindowInsets.safeDrawing.only(
                    WindowInsetsSides.Horizontal,
                ),
            ),
        entries = navigator.state.toEntries(entryProvider),
        onBack = navigator::goBack
    )
}