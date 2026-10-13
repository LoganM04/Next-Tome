package com.lmcoding.nexttome.feature.library.components

import androidx.compose.animation.Animatable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.lmcoding.nexttome.ui.components.TextList
import com.lmcoding.nexttome.ui.components.TextListDisplay

@Composable
internal fun LibraryScreenContent(){
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        repeat(3){
            LibraryShelfContainer()
        }
    }
}

@Composable
private fun LibraryShelfContainer(){
    Column (
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        LibraryShelfContainerTitle()
        LibraryShelf()
    }
}

@Composable
private fun LibraryShelfContainerTitle(){
    Column (
        modifier = Modifier.fillMaxWidth(),
    ){
        Text("Ttiel")
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            TextList(
                modifier = Modifier.weight(1f),
                strings = listOf("Manga", "il manque le T9"),
                display = TextListDisplay.Horizontal,
                maxItems = 2,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            ShelfCountBadge(owned = 13, total = 14)
        }
    }
}

@Composable
private fun ShelfCountBadge(owned: Int, total: Int) {
    Text(
        text = "$owned / $total",
        style = MaterialTheme.typography.labelMedium,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.onPrimaryContainer,
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primaryContainer, CircleShape)
            .padding(horizontal = 10.dp, vertical = 4.dp),
    )
}