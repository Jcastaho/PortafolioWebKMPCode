package org.straccion.project.utils

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned

fun Modifier.detectVisibility(
    onVisibilityChanged: (Boolean) -> Unit
): Modifier = this.onGloballyPositioned { coordinates ->
    val windowBounds = coordinates.parentLayoutCoordinates?.boundsInWindow()
    val componentBounds = coordinates.boundsInWindow()

    val isVisible = if (windowBounds != null && componentBounds != null) {
        !(componentBounds.right < windowBounds.left ||
                componentBounds.left > windowBounds.right ||
                componentBounds.bottom < windowBounds.top ||
                componentBounds.top > windowBounds.bottom)
    } else {
        false
    }
    onVisibilityChanged(isVisible)
}

