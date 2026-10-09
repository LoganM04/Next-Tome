package com.lmcoding.nexttome.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation3.runtime.NavKey
import com.lmcoding.nexttome.annotation.ThemePreviews
import com.lmcoding.nexttome.navigation.Route
import com.lmcoding.nexttome.navigation.TopLevelDestination
import org.jetbrains.compose.resources.painterResource

@Composable
fun AppNavigationBar(
    isVisible: Boolean,
    currentTopLevelKey: NavKey,
    onTabClick: (NavKey) -> Unit,
) {
    if (!isVisible) return

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceContainer,
    ) {
        TopLevelDestination.entries.forEach { tab ->
            val selected = tab.route == currentTopLevelKey
            NavigationBarItem(
                selected = selected,
                onClick = { onTabClick(tab.route) },
                icon = { Icon(painterResource(tab.icon), contentDescription = null) },
                label = {
                    Text(
                        tab.label,
                        fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium,
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.secondaryContainer,
                    selectedIconColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    selectedTextColor = MaterialTheme.colorScheme.onSurface,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                ),
            )
        }
    }
}

@ThemePreviews
@Composable
private fun AppNavigationBarPreview(){
    PreviewWrapper {
        AppNavigationBar(
            isVisible = true,
            currentTopLevelKey = Route.Library,
            onTabClick = {},
        )
    }
}