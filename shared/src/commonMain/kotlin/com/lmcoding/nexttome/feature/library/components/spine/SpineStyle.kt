package com.lmcoding.nexttome.feature.library.components.spine

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.lmcoding.nexttome.feature.library.domain.BookType

data class SpineStyle(
    val width: Dp,
    val height: Dp,
    val bandHeight: Dp,
    val showTitle: Boolean,
)

val BookType.spineStyle: SpineStyle
    get() = when (this) {
        BookType.MANGA -> SpineStyle(width = 26.dp, height = 128.dp, bandHeight = 16.dp, showTitle = false)
        BookType.BD -> SpineStyle(width = 20.dp, height = 152.dp, bandHeight = 0.dp, showTitle = false)
        BookType.COMICS -> SpineStyle(width = 22.dp, height = 140.dp, bandHeight = 6.dp, showTitle = false)
        BookType.ROMAN -> SpineStyle(width = 34.dp, height = 146.dp, bandHeight = 0.dp, showTitle = true)
        BookType.AUTRE -> SpineStyle(width = 28.dp, height = 140.dp, bandHeight = 0.dp, showTitle = true)
    }

data class SpineColors(
    val background: Color,
    val content: Color,
)


@Composable
fun BookType.defaultSpineColors(): SpineColors {
    val colorScheme = MaterialTheme.colorScheme
    return when (this) {
        BookType.MANGA -> SpineColors(colorScheme.surfaceContainerLowest, colorScheme.onSurface)
        BookType.BD -> SpineColors(colorScheme.inverseSurface, colorScheme.inverseOnSurface)
        BookType.COMICS -> SpineColors(colorScheme.tertiaryContainer, colorScheme.onTertiaryContainer)
        BookType.ROMAN -> SpineColors(colorScheme.primary, colorScheme.onPrimary)
        BookType.AUTRE -> SpineColors(colorScheme.secondary, colorScheme.onSecondary)
    }
}

