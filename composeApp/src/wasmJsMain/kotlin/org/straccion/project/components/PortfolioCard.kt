package org.straccion.project.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.straccion.project.models.Portfolio


@Composable
fun PortfolioCard(
    portfolio: Portfolio
) {
    Column(
        modifier = Modifier
            .width(350.dp)
            .fillMaxHeight()
            .clip(RoundedCornerShape(16.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagen grande del portfolio
        Image(
            painter = painterResource(portfolio.image),
            contentDescription = portfolio.title,
            modifier = Modifier
                .width(350.dp)
                .height(350.dp),
            contentScale = ContentScale.Fit
        )

        // Espaciado
        Spacer(modifier = Modifier.height(16.dp))

        // Título
        Text(
            text = portfolio.title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        // Descripción
        Text(
            text = portfolio.description,
            fontSize = 16.sp
        )
    }
}