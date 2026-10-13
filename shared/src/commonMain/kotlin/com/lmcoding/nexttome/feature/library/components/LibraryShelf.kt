package com.lmcoding.nexttome.feature.library.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lmcoding.nexttome.annotation.ThemePreviews
import com.lmcoding.nexttome.ui.components.PreviewWrapper
import com.lmcoding.nexttome.ui.theme.AppTheme

@Composable
fun LibraryShelf(
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(
                color = MaterialTheme.colorScheme.outlineVariant,
                shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
            )
    ){
        LibraryShelfPlank(Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
private fun LibraryShelfPlank(modifier: Modifier){
    Column (modifier = Modifier.fillMaxWidth().height(14.dp).then(modifier)){
        Box(modifier = Modifier.fillMaxWidth().height(10.dp).background(AppTheme.shelfColors.plank))
        Box(modifier = Modifier.fillMaxWidth().height(4.dp).background(AppTheme.shelfColors.plankEdge))
    }
}

@Composable
@ThemePreviews
private fun LibraryShelfPreview(){
    PreviewWrapper {
        LibraryShelf(modifier = Modifier.padding(12.dp))
    }
}