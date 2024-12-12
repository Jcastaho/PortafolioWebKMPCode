package org.straccion.project.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.straccion.project.models.Service
import org.straccion.project.models.Theme
import org.straccion.project.utils.Res

@Composable
fun ServiceCard(
    service: Service
) {
    Card(
        modifier = Modifier
            .height(350.dp)
            .width(300.dp)
            .padding(bottom = 26.dp),
        elevation = 1.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(service.icon),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(shape = RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomStart = 20.dp)) // Aquí personalizamos la forma
                    .background(Theme.Secondary.color)
                    .padding(12.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.padding(bottom = 26.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = service.title,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = service.description,
                )
            }
        }
    }
}
