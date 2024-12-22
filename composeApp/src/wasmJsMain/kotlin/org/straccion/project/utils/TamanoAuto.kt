package org.straccion.project.utils

import androidx.compose.runtime.*
import kotlinx.browser.window

@Composable
fun rememberScreenSize(): Int {
    var screenWidth by remember { mutableStateOf(window.innerWidth) }
    LaunchedEffect(Unit) {
        window.addEventListener("resize", {
            screenWidth = window.innerWidth
        })
    }
    return screenWidth
}