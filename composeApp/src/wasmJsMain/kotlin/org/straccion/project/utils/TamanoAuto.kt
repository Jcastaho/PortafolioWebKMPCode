package org.straccion.project.utils

import androidx.compose.runtime.Composable
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