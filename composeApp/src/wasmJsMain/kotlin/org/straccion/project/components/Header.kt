package org.straccion.project.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.straccion.project.models.Section
import org.straccion.project.models.Theme
import org.straccion.project.utils.Res

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth(0.85f)
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LeftSide()
        RightSide()
    }
}

@Composable
fun LeftSide(

) {
    var isHovered by remember { mutableStateOf(false) }
    val movimiento by animateFloatAsState(
        targetValue = if (isHovered) -15f else 0f,
        animationSpec = tween(
            durationMillis = 1600, // Duración de la animación en milisegundos
            easing = FastOutSlowInEasing // Easing para una transición suave
        )
    )

    Row(
        modifier = Modifier
            .padding(end = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(70.dp)
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
                .rotate(if (isHovered) -20f else 0f)
                .graphicsLayer {
                    // Animación de rotación
                    rotationZ = movimiento
                },
            painter = painterResource(Res.Image.logo),
            contentDescription = "Logo",
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun RightSide(

) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Theme.LighterGray.color)
            .padding(
                vertical = 20.dp,
                horizontal = 40.dp
            ),
        horizontalArrangement = Arrangement.End
    ) {
        Section.values().take(6).forEach { section ->
            menus(
                section.title,
                path = section.path,
            )
        }
    }
}

//falta agregar el path
@Composable
fun menus(
    text: String,
    path: String,
    hoveredColor: Color = Theme.Primary.color,
    normalColor: Color = Color.Black,
    modifier: Modifier = Modifier
) {
    var isHovered by remember { mutableStateOf(false) }
    Text(
        modifier = modifier
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
            .clickable {  }
            .testTag(path)
            .padding(end = 30.dp),
        text = text,
        style = TextStyle(
            color = if (isHovered) hoveredColor else normalColor,
            fontSize = 18.sp // Ajusta el tamaño según lo necesites
        )
    )
}