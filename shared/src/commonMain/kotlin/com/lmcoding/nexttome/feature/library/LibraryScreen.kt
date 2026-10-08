package com.lmcoding.nexttome.feature.library

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lmcoding.nexttome.annotation.ThemePreviews
import com.lmcoding.nexttome.ui.components.ScreenFrame

@Composable
fun LibraryScreen(){
    ScreenFrame(
        modifier = Modifier.fillMaxSize(),
    ) {
        Text("Library")
    }
}

@Composable
private fun LibraryScreen(state : String){

}

@ThemePreviews
@Composable
private fun LibraryScreenPreview(){
    LibraryScreen(
        state = ""
    )
}