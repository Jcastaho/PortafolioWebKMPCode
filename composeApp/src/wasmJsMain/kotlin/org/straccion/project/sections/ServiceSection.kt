package org.straccion.project.sections

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.straccion.project.components.SectionTitle
import org.straccion.project.components.ServiceCard
import org.straccion.project.models.Section
import org.straccion.project.models.Service
import org.straccion.project.utils.AnchoPantalla
import org.straccion.project.utils.TamanoAuto
import org.straccion.project.utils.rememberScreenSize

@Composable
fun ServiceSection() {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(start = 15.dp, end = 15.dp),
    ) {
        ServiceContent()
    }
}

@Composable
fun ServiceContent() {
    val screenWidth = rememberScreenSize()

    val columnCount = when {
        screenWidth > 1300 -> 3 // Máximo 3 columnas para pantallas anchas
        screenWidth > 890 -> 2 // Máximo 2 columnas para pantallas medianas
        else -> 1 // 1 columna para pantallas pequeñas
    }

    val groupedServices = Service.entries.chunked(columnCount) // Agrupa elementos según el número de columnas
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            section = Section.About,
            alignment = if (screenWidth > 890) Alignment.CenterHorizontally
            else Alignment.Start
        )
        Spacer(modifier = Modifier.height(20.dp))
        groupedServices.forEach { rowItems ->
            Row(
                modifier = Modifier.wrapContentSize(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                rowItems.forEach { service ->
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        ServiceCard(service = service, screenWidth = screenWidth)
                    }
                }
                // Si faltan elementos para completar la fila, agrega espacio vacío
                repeat(columnCount - rowItems.size) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}
