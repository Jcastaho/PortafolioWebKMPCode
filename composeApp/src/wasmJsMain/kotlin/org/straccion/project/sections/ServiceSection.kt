package org.straccion.project.sections

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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

@Composable
fun ServiceSection() {
    val screenHeight = TamanoAuto()
    Box(
        modifier = Modifier
            //.heightIn(screenHeight + 500.dp)
            .height(screenHeight + 100.dp)
            .padding(vertical = 40.dp, horizontal = 20.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        ServiceContent()
    }
}

@Composable
fun ServiceContent() {
    val getWindowWidth = AnchoPantalla()
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(bottom = 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            SectionTitle(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 50.dp),
                section = Section.Service,
            )
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 290.dp), // Adaptive para ajustar columnas automáticamente
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(Service.entries.size) { index ->
                        ServiceCard(service = Service.entries[index])
                    }
                }
            }
        }
    }
}

