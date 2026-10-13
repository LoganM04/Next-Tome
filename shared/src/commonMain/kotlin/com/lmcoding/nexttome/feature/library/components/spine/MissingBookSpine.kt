package com.lmcoding.nexttome.feature.library.components.spine

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lmcoding.nexttome.annotation.ThemePreviews
import com.lmcoding.nexttome.feature.library.domain.BookType
import com.lmcoding.nexttome.ui.components.PreviewWrapper
import com.lmcoding.nexttome.ui.theme.AppTheme

@Composable
fun MissingBookSpine(
    type: BookType,
    volumeNumber: Int,
    modifier: Modifier = Modifier,
) {
    val style = type.spineStyle
    val strokeColor = AppTheme.shelfColors.missingStroke

    Box(
        modifier = modifier
            .size(width = style.width, height = style.height)
            .drawBehind {
                drawRoundRect(
                    color = strokeColor,
                    cornerRadius = CornerRadius(3.dp.toPx()),
                    style = Stroke(
                        width = 1.5.dp.toPx(),
                        pathEffect = PathEffect.dashPathEffect(
                            floatArrayOf(4.dp.toPx(), 3.dp.toPx())
                        ),
                    ),
                )
            }
            .padding(bottom = 6.dp),
        contentAlignment = Alignment.BottomCenter,
    ) {
        Text(
            text = volumeNumber.toString(),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@ThemePreviews
@Composable
private fun MissingBookSpinePreview() {
    PreviewWrapper {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(3.dp),
            verticalAlignment = Alignment.Bottom,
        ) {
            BookSpine(type=BookType.MANGA, volumeNumber = 8)
            MissingBookSpine(type=BookType.MANGA, volumeNumber = 9)
            BookSpine(type=BookType.MANGA, volumeNumber = 10)
        }
    }
}