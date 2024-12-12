package org.straccion.project.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.straccion.project.components.SectionTitle
import org.straccion.project.components.ServiceCard
import org.straccion.project.models.Section
import org.straccion.project.models.Service
import org.straccion.project.utils.TamanoAuto

@Composable
fun ServiceSection() {
    val screenHeight = TamanoAuto()
    Box(
        modifier = Modifier
            .height(screenHeight) // se le puede sumar +500.dp cuand ola pantalla es mas pequeña
            .padding(vertical = 50.dp, horizontal = 180.dp), // o mas facil se le suma mucho padin en este lado  antes de sumar esos 500.dp
        contentAlignment = Alignment.Center
    ) {
        ServiceContent()
    }
}

@Composable
fun ServiceContent() {
    val screenHeight = TamanoAuto()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.8f), // Ajustar el ancho al 80% de la pantalla
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            SectionTitle(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                section = Section.Service,
            )
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxWidth(),
                columns = GridCells.Adaptive(minSize = 280.dp), // Cambia el número de columnas según el tamaño de la pantalla
                contentPadding = PaddingValues(25.dp),
                horizontalArrangement = Arrangement.spacedBy(25.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(Service.entries.size) { index ->
                    ServiceCard(service = Service.entries[index])
                }
            }
        }
    }
}
