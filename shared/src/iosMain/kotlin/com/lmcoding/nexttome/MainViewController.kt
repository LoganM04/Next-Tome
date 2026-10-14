package com.lmcoding.nexttome

import androidx.compose.ui.window.ComposeUIViewController
import com.lmcoding.nexttome.di.AppKoin

fun MainViewController() = ComposeUIViewController (
    configure = { AppKoin.init() }
){ App() }