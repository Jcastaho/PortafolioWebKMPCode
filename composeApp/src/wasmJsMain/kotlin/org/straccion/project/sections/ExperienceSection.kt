package org.straccion.project.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.min
import org.straccion.project.components.ExperienceCard
import org.straccion.project.components.SectionTitle
import org.straccion.project.models.Experience
import org.straccion.project.models.Section
import org.straccion.project.utils.rememberScreenSize

@Composable
fun ExperienceSection() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 50.dp),
        verticalArrangement = Arrangement.Center
    ) {
        ExperienceContent()
    }
}

@Composable
fun ExperienceContent() {
    val screenWidth = rememberScreenSize()

    val imageSizeDp = (((screenWidth - 250) * 250) / 1920).dp
    // Aplicar límites al tamaño de la imagen
    val size = max(0.dp, min(250.dp, imageSizeDp))


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = if (screenWidth > 415) size else 10.dp)
    ) {
        if (screenWidth > 1170) {
            // Línea vertical central
            Box(
                modifier = Modifier
                    .width(2.dp)
                    .height(430.dp)
                    .align(if (screenWidth > 1000) Alignment.TopCenter else Alignment.BottomCenter)  // Cambiado a TopCenter
                    .absoluteOffset(y = if (screenWidth > 1171) 125.dp else 160.dp)  // Ajusta este valor para mover el punto de inicio
                    .background(Color.Black)
            )
        }

// Contenido principal
        if (screenWidth > 1170) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Título de la sección
                SectionTitle(
                    modifier = Modifier.padding(bottom = 25.dp),
                    section = Section.Experience,
                    alignment = Alignment.CenterHorizontally
                )
                // Tarjetas de experiencia
                Experience.entries.forEachIndexed { index, experience ->
                    ExperienceCard(
                        isActive = index == 0, // Resaltar el primero
                        experience = experience
                    )
                }
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp), // Asegura un padding si lo necesitas, o elimínalo si no es necesario
                horizontalAlignment = Alignment.Start // Aline
            ) {
                // Título de la sección
                SectionTitle(
                    modifier = Modifier.padding(bottom = 25.dp),
                    section = Section.Experience,
                    alignment = Alignment.Start
                )
                Experience.entries.forEachIndexed { index, experience ->
                    ExperienceCard(
                        isActive = index == 0, // Resaltar el primero
                        experience = experience,
                        isColumn = true
                    )
                }

            }
        }
    }
}