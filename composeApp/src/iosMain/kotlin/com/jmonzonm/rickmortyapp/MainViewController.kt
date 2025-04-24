package com.jmonzonm.rickmortyapp

import androidx.compose.ui.window.ComposeUIViewController
import com.jmonzonm.rickmortyapp.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = { initKoin() }) { App() }