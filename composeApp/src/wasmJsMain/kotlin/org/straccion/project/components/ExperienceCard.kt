package org.straccion.project.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.straccion.project.models.Experience
import org.straccion.project.models.Theme

@Composable
fun ExperienceCard(
    isActive: Boolean,
    experience: Experience
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(0.7f)
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(26.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Descripción ocupa la mitad del ancho
        ExperienceDescriptionKMP(
            isActive = isActive,
            description = experience.description,
            modifier = Modifier.weight(1f) // Ocupa la mitad
        )

        // Número al centro
        ExperienceNumberKMP(
            isActive = isActive,
            number = experience.number
        )

        // Detalles al lado del número
        ExperienceDetailsKMP(
            jobPosition = experience.jobPosition,
            dateRange = "${experience.from} - ${experience.to}",
            company = experience.company,
            modifier = Modifier.weight(1f) // Ocupa el resto
        )
    }
}

@Composable
fun ExperienceNumberKMP(
    isActive: Boolean,
    number: String
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(40.dp)
            .border(
                width = 3.dp,
                color = if (isActive) Color(0xFF009688) else Color.Gray,
                shape = CircleShape
            )
            .background(
                color = if (isActive) Color(0xFF009688) else Color.White,
                shape = CircleShape
            )
    ) {
        Text(
            text = number,
            color = if (isActive) Color.White else Color(0xFF009688),
            style = MaterialTheme.typography.body2
        )
    }
}

@Composable
fun ExperienceDescriptionKMP(
    isActive: Boolean,
    description: String,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .background(
                color = if (isActive) Color(0xFF009688) else Color.LightGray,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp)
    ) {
        Text(
            text = description,
            color = if (isActive) Color.White else Color.DarkGray,
            style = MaterialTheme.typography.body2
        )
    }
}

@Composable
fun ExperienceDetailsKMP(
    jobPosition: String,
    dateRange: String,
    company: String,
    modifier: Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = jobPosition,
            style = MaterialTheme.typography.subtitle1,
            color = Color(0xFF009688)
        )
        Text(
            text = dateRange,
            style = MaterialTheme.typography.body1,
            color = Color.Gray
        )
        Text(
            text = company,
            style = MaterialTheme.typography.body1,
            color = Color(0xFF009688)
        )
    }
}