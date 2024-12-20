package org.straccion.project.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.straccion.project.models.Service
import org.straccion.project.models.Theme


@Composable
fun ServiceCard(
    service: Service,
    screenWidth: Int
) {
    var mouse by remember { mutableStateOf(false) }
    val grayscaleLevel by animateColorAsState(
        targetValue = if (mouse)Theme.Primary.color else Color.White,
        animationSpec = tween(
            durationMillis = 350, // Duración de la animación en milisegundos
            easing = FastOutSlowInEasing // Easing para una transición suave
        )
    )
    Card(
        modifier = Modifier
            .height(350.dp)
            .width(if (screenWidth > 360)400.dp else 460.dp)
            .pointerInput(Unit) {
                awaitPointerEventScope {
                    while (true) {
                        val event = awaitPointerEvent()
                        when (event.type) {
                            PointerEventType.Enter -> mouse = true
                            PointerEventType.Exit -> mouse = false
                        }
                    }
                }
            },
        elevation = 2.dp,
        shape = RoundedCornerShape(16.dp),
        backgroundColor = grayscaleLevel
    ) {
        Column(
            modifier =
            Modifier.padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(service.icon),
                contentDescription = null,
                modifier = Modifier
                    .size(if (screenWidth > 360)100.dp else 65.dp)
                    .clip(
                        shape = RoundedCornerShape(
                            topStart = 20.dp,
                            topEnd = 20.dp,
                            bottomStart = 20.dp
                        )
                    ) // Aquí personalizamos la forma
                    .background(Color.White)
                    .padding(12.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = service.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(18.dp))
                Text(
                    text = service.description,
                    fontSize = 14.sp
                )
            }
        }
    }
}
