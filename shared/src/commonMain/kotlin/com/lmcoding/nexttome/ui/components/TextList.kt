package com.lmcoding.nexttome.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

enum class TextListDisplay { Vertical, Horizontal }

@Composable
fun TextList(
    modifier: Modifier = Modifier,
    strings : List<String>,
    display : TextListDisplay,
    maxItems: Int = Int.MAX_VALUE,
    separator: String = " · ",
    overflowLabel: (hiddenCount: Int) -> String = { "+$it" },
    style: TextStyle = LocalTextStyle.current,
    color: Color = Color.Unspecified,
){
    val limit = maxItems.coerceAtLeast(1)

    val items = strings.filter { it.isNotBlank() }
    val visible = items.take(limit)
    val hiddenCount = items.size - visible.size
    val overflow = if (hiddenCount > 0) overflowLabel(hiddenCount) else null

    when(display) {
        TextListDisplay.Vertical -> TextListVertical(modifier, visible, overflow, style, color)
        TextListDisplay.Horizontal -> TextListHorizontal(modifier, visible, overflow, separator, style, color)
    }
}

@Composable
private fun TextListVertical(
    modifier: Modifier,
    items: List<String>,
    overflow: String?,
    style: TextStyle,
    color: Color,
){
    Column(modifier, verticalArrangement = Arrangement.spacedBy(4.dp)) {
        items.forEach { Text(it, style = style, color = color) }
        overflow?.let {
            Text(it, style = style, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

@Composable
private fun TextListHorizontal(
    modifier: Modifier,
    items: List<String>,
    overflow: String?,
    separator: String,
    style: TextStyle,
    color: Color,
){
    Text(
        text = (items + listOfNotNull(overflow)).joinToString(separator),
        modifier = modifier,
        style = style,
        color = color,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}