package org.straccion.project.utils

import androidx.compose.runtime.*
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.browser.window

@Composable
fun TamanoAuto(): Dp {
    val heightInPx = getWindowHeight()
    val density = window.devicePixelRatio // Obtiene el factor de densidad del dispositivo
    val heightInDp = heightInPx / density
    return heightInDp.dp
}

fun getWindowHeight(): Float {
    return window.innerHeight.toFloat()
}

fun AnchoPantalla(): Dp {
    val widthInPx = window.innerWidth.toFloat()
    val density = window.devicePixelRatio.toFloat()

    // Conversión a dp
    val widthInDp = (widthInPx / density).dp

    return widthInDp
}

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