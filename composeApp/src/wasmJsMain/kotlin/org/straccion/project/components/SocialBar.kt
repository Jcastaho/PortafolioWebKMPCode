package org.straccion.project.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import practica_compose.composeapp.generated.resources.*
import practica_compose.composeapp.generated.resources.Res
import practica_compose.composeapp.generated.resources.facebook

@Composable
fun SocialBar(
    modifier: Modifier = Modifier,
    isVertical: Boolean = false
) {
    val socialMedia = listOf(
        Pair(Res.drawable.facebook, "https://www.facebook.com"),
        Pair(Res.drawable.github, "https://github.com/Jcastaho"),
        Pair(Res.drawable.linkedin, "https://www.linkedin.com/in/juan-david-castano/")
    )
    // Redirigir al navegador
    val uriHandler = LocalUriHandler.current

    val arrangement = if (isVertical) Arrangement.Center else Arrangement.spacedBy(12.dp)

    if (isVertical) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = arrangement,
            modifier = modifier.fillMaxHeight()
        ) {
            socialMedia.forEach { (iconPath, url) ->
                AnimatedIcon(iconPath = iconPath, onClick = { uriHandler.openUri(url) })
            }
        }
    } else {
        Row(
            horizontalArrangement = arrangement,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
        ) {
            socialMedia.forEach { (iconPath, url) ->
                AnimatedIcon(iconPath = iconPath, onClick = { uriHandler.openUri(url) })
            }
        }
    }
}
@Composable
fun AnimatedIcon(iconPath: DrawableResource, onClick: () -> Unit) {
    var isHovered by remember { mutableStateOf(false) }
    // Tamaño animado
    val size by animateDpAsState(targetValue = if (isHovered) 48.dp else 38.dp)

    // Desplazamiento animado
    val offsetY by animateDpAsState(targetValue = if (isHovered) (-5).dp else 0.dp)

    // Opacidad de los otros íconos
    val alpha by animateFloatAsState(targetValue = if (isHovered) 1f else 0.8f)
    Image(
        painter = painterResource(iconPath),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .size(size)
            .padding(4.dp)
            .offset(y = offsetY)
            .clickable { onClick() } // Redirección
            .pointerHoverIcon(icon = PointerIcon.Hand)
            .pointerInput(Unit) {
                awaitPointerEventScope {
                    while (true) {
                        val event = awaitPointerEvent()
                        when (event.type) {
                            PointerEventType.Enter -> isHovered = true
                            PointerEventType.Exit -> isHovered = false
                        }
                    }
                }
            }
            .alpha(alpha) // Opacidad animada
    )
}