package org.straccion.project.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.straccion.project.components.AchievementCard
import org.straccion.project.models.Achievements
import org.straccion.project.models.Theme

@Composable
fun AchievementsSection() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Theme.LightGray.color)
            .padding(vertical = 50.dp),
        verticalArrangement = Arrangement.Center
    ) {
        AchievementsContent()
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AchievementsContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Cambiamos Row por FlowRow para soporte responsivo
        FlowRow(
            modifier = Modifier
                .wrapContentSize() // Tamaño ajustado al contenido
                .padding(horizontal = 20.dp)
                .align(Alignment.Center) // Ajusta el padding según tu diseño
        ) {
            Achievements.entries.forEach { achievements ->
                AchievementCard(
                    targetNumber = achievements.number, // El número final de cada logro
                    achievements = achievements
                )
            }
        }
    }
}