package org.straccion.project.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.straccion.project.models.Portfolio
import org.straccion.project.utils.rememberScreenSize


@Composable
fun PortfolioCard(
    portfolio: Portfolio
) {
    val screenWidth = rememberScreenSize()
    val imageSizeDp = (((screenWidth * 1.3) * 350) / 1920).dp

    // Aplicar límites al tamaño de la imagen
    val size = max(250.dp, min(350.dp, imageSizeDp))
    Column(
        modifier = Modifier
            .width(size)
            .fillMaxHeight()
            .padding(35.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagen grande del portfolio
        Image(
            painter = painterResource(portfolio.image),
            contentDescription = portfolio.title,
            modifier = Modifier
                .width(size)
                .height(size),
            contentScale = ContentScale.Fit
        )

        // Espaciado
        Spacer(modifier = Modifier.height(16.dp))

        // Título
        Text(
            text = portfolio.title,
            fontSize = if (screenWidth > 700)20.sp else 18.sp,
            fontWeight = FontWeight.Bold
        )

        // Descripción
        Text(
            text = portfolio.description,
            fontSize = if (screenWidth > 700)16.sp else 15.sp
        )
    }
}