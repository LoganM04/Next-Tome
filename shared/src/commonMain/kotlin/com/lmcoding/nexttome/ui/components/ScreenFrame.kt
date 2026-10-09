package com.lmcoding.nexttome.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.lmcoding.nexttome.ui.LocalScaffoldPadding

@Composable
fun ScreenFrame(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    topBar: @Composable () -> Unit = {},
    content: @Composable () -> Unit
){
    Surface(
        modifier = Modifier.fillMaxSize().then(modifier),
        color = backgroundColor
    ) {
        Column (Modifier.fillMaxSize()){
            Box(Modifier.statusBarsPadding()){ topBar() }
            Box(Modifier.weight(1f)) { content() }
        }
    }
}
