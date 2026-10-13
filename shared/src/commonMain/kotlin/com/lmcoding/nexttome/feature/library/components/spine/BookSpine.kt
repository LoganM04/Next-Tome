package com.lmcoding.nexttome.feature.library.components.spine

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lmcoding.nexttome.annotation.ThemePreviews
import com.lmcoding.nexttome.feature.library.domain.BookType
import com.lmcoding.nexttome.ui.components.PreviewWrapper
import com.lmcoding.nexttome.ui.ext.vertical

private val SpineShape = RoundedCornerShape(
    topStart = 3.dp, topEnd = 3.dp,
    bottomStart = 1.dp, bottomEnd = 1.dp,
)

@Composable
internal fun BookSpine(
    modifier: Modifier = Modifier,
    type: BookType,
    volumeNumber: Int,
    colors: SpineColors = type.defaultSpineColors(),
    bandColor: Color = MaterialTheme.colorScheme.primary,
    title: String? = null,
){
    val style = type.spineStyle

    Box(
        modifier = modifier
            .size(width = style.width, height = style.height)
            .clip(SpineShape)
            .background(colors.background),
    ){
        Column(
            modifier = Modifier.fillMaxSize().padding(bottom = 6.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            if (style.bandHeight > 0.dp) {
                SpineBand(height = style.bandHeight, color = bandColor)
            }

            if (style.showTitle && title != null) {
                SpineTitle(title, colors.content, Modifier.weight(1f))
            } else {
                Spacer(Modifier.weight(1f))
            }

            SpineNumber(volumeNumber, colors.content)
        }

        SpineEdgeShadow(Modifier.align(Alignment.CenterEnd))
    }
}

@Composable
private fun SpineBand(height: Dp, color: Color) {
    Box(Modifier.fillMaxWidth().height(height).background(color))
}

@Composable
private fun SpineTitle(title: String, color: Color, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.padding(vertical = 8.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = title.uppercase(),
            color = color,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.2.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.vertical().rotate(-90f),
        )
    }
}

@Composable
private fun SpineNumber(number: Int, color: Color) {
    Text(
        text = number.toString(),
        color = color,
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
    )
}

@Composable
private fun SpineEdgeShadow(modifier: Modifier = Modifier) {
    Box(
        modifier
            .width(3.dp)
            .fillMaxHeight()
            .background(Color.Black.copy(alpha = 0.13f))
    )
}

@ThemePreviews
@Composable
private fun BookSpinePreview() {
    PreviewWrapper {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(3.dp),
            verticalAlignment = Alignment.Bottom,
        ) {
            BookSpine(type= BookType.MANGA, volumeNumber = 1)
            BookSpine(type= BookType.BD, volumeNumber = 2)
            BookSpine(type= BookType.COMICS, volumeNumber = 3)
            BookSpine(type= BookType.ROMAN, volumeNumber = 4, title = "Passe-miroir")
            BookSpine(type= BookType.AUTRE, volumeNumber = 5, title = "Artbook")
        }
    }
}