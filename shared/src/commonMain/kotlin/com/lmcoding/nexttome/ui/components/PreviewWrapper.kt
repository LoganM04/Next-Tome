package com.lmcoding.nexttome.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import com.lmcoding.nexttome.ui.theme.AppTheme

@Composable
fun PreviewWrapper(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    AppTheme(darkTheme = darkTheme) {
        content()
    }
}