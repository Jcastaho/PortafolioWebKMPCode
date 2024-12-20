package org.straccion.project

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import org.straccion.project.sections.*

@Composable
fun App() {
    val scrollState = rememberScrollState()

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            MainSection()

            val aboutOffset = remember { mutableStateOf(false) }
            AboutSection(
                viewportEntered = aboutOffset.value
            )
            LaunchedEffect(scrollState.value) {
                // Calculamos el 25% de 954.dp
                val quarterScreen = 954f * 0.25  // esto sería aproximadamente 238.5

                // Verificamos si el scroll ha superado el 25% de la pantalla inicial
                val hasScrolledQuarter = scrollState.value >= quarterScreen

                if (hasScrolledQuarter) {
                    aboutOffset.value = true
                }
            }
            ServiceSection()
            PortafolioSection()
            AchievementsSection()
            TestimonialSection()
            ExperienceSection()
            ContacSection()
            FooterSection()
        }
    }
}