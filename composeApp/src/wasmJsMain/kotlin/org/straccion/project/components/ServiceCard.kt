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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.straccion.project.models.Service
import org.straccion.project.models.Theme
import org.straccion.project.utils.AnchoPantalla
import org.straccion.project.utils.Res
import org.straccion.project.utils.TamanoAuto

@Composable
fun ServiceCard(
    service: Service
) {

    Card(
        modifier = Modifier
            .height(400.dp)
            .padding(end = 20.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(service.icon),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(
                        shape = RoundedCornerShape(
                            topStart = 20.dp,
                            topEnd = 20.dp,
                            bottomStart = 20.dp
                        )
                    ) // Aquí personalizamos la forma
                    .background(Theme.Secondary.color)
                    .padding(12.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = service.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(18.dp))
                Text(
                    text = service.description,
                    fontSize = 14.sp
                )
            }
        }
    }
}
