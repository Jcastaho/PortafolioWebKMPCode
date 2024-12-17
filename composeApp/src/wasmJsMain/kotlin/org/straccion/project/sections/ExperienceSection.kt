package org.straccion.project.sections

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.straccion.project.components.ExperienceCard
import org.straccion.project.components.SectionTitle
import org.straccion.project.models.Experience
import org.straccion.project.models.Section

@Composable
fun ExperienceSection() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(vertical = 50.dp),
        verticalArrangement = Arrangement.Center
    ) {
        ExperienceContent()
    }
}

@Composable
fun ExperienceContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        SectionTitle(
            modifier = Modifier.padding(bottom = 25.dp),
            section = Section.Experience
        )
        Experience.entries.forEachIndexed { index, experience ->
            ExperienceCard(
                isActive = index == 0, // Resaltar el primero
                experience = experience
            )
        }
    }
}