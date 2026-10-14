package com.lmcoding.nexttome.feature.library.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lmcoding.nexttome.annotation.ThemePreviews
import com.lmcoding.nexttome.feature.library.domain.BookType
import com.lmcoding.nexttome.feature.library.domain.label
import com.lmcoding.nexttome.ui.components.PreviewWrapper
import com.lmcoding.nexttome.ui.components.TextList
import com.lmcoding.nexttome.ui.components.TextListDisplay
import nexttome.shared.generated.resources.Res
import nexttome.shared.generated.resources.ic_grid_view
import org.jetbrains.compose.resources.painterResource

@Composable
internal fun LibraryScreenHeader(
    modifier: Modifier = Modifier,
    onAddBook: () -> Unit = {},
){
    Column (
        modifier = Modifier.fillMaxWidth().then(modifier),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        LibraryScreenHeaderTitleRow(onAddBook)
        Column {
            TextList(
                modifier = Modifier.fillMaxWidth(),
                strings = listOf("4 séries", "27 tomes", "4 à compléter"),
                display = TextListDisplay.Horizontal,
                maxItems = 3,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            LibraryScreenHeaderFilter()
        }
    }
}

@Composable
private fun LibraryScreenHeaderTitleRow(onAddBook: () -> Unit){
    val iconSize = 24f

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text("Ma biblio", style = MaterialTheme.typography.titleLarge)

        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Ajouter un livre",
                modifier = Modifier.size(iconSize.dp).clickable(onClick = onAddBook),
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null,
                modifier = Modifier.size(iconSize.dp),
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Icon(
                painter = painterResource(Res.drawable.ic_grid_view),
                contentDescription = null,
                modifier = Modifier.size(iconSize.dp),
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun LibraryScreenHeaderFilter(
//    selectedType: BookType?,
//    onTypeSelected: (BookType?) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(end = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        BookTypeChip("Tous", selected = true) {  }
        BookType.entries.forEach { type ->
            BookTypeChip(type.label, selected = false) {  }
        }
    }
}

@Composable
private fun BookTypeChip(label: String, selected: Boolean, onClick: () -> Unit) {
    FilterChip(
        selected = selected,
        onClick = onClick,
        label = { Text(label) },
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = null,
                    modifier = Modifier.size(FilterChipDefaults.IconSize),
                )
            }
        } else null,
    )
}

@ThemePreviews
@Composable
private fun LibraryScreenHeaderPreview(){
    PreviewWrapper {
        LibraryScreenHeader()
    }
}
        