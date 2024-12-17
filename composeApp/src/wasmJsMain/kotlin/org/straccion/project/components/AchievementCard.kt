package org.straccion.project.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import org.straccion.project.models.Achievements
import org.straccion.project.models.Theme
import org.straccion.project.utils.detectVisibility

@Composable
fun AchievementCard(
    modifier: Modifier = Modifier,
    targetNumber: Int,
    achievements: Achievements
) {
    var isVisible by remember { mutableStateOf(false) }
    var animatedNumber by remember { mutableStateOf(0) }
    val grayscaleLevel by animateFloatAsState(
        targetValue = 0.5f
    )
    // Animar cada número de forma independiente
    LaunchedEffect(isVisible) {
        if (isVisible) {
            for (i in 0..targetNumber) {
                animatedNumber = i
                delay(90L * animatedNumber) // Controla la velocidad de la animación
            }
        } else {
            animatedNumber = 0 // Reiniciar si no es visible
        }
    }
    Row(
        modifier = modifier
            .width(250.dp)
            .height(100.dp)
            .padding(10.dp)
            .detectVisibility { newVisibility ->
                isVisible = newVisibility
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(70.dp)
                .padding(end = 20.dp),
            painter = painterResource(achievements.icon),
            contentDescription = "achievements Icon"
        )
        Column(
            modifier = Modifier.padding(end = 20.dp)
        ) {
            Text(
                style = TextStyle(
                    color = Theme.Primary.color
                ),
                text = if (achievements == Achievements.Completed) "${animatedNumber}+"
                else "$animatedNumber",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                style = TextStyle(
                    color = Theme.Secondary.color.copy(alpha = grayscaleLevel)
                ),
                text = achievements.description,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}