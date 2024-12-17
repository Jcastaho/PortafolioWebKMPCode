package org.straccion.project

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import org.straccion.project.sections.*

@Composable
fun App() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            MainSection()
            AboutSection()
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