package org.straccion.project.sections

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.straccion.project.components.SectionTitle
import org.straccion.project.components.SkillBar
import org.straccion.project.models.Section
import org.straccion.project.models.Skills
import org.straccion.project.models.Theme
import org.straccion.project.utils.Constants.Lorem
import org.straccion.project.utils.Res
import org.straccion.project.utils.TamanoAuto
import org.straccion.project.utils.detectVisibility
import org.straccion.project.utils.rememberScreenSize

@Composable
fun AboutSection() {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(start = 15.dp, end = 15.dp),
    ) {
        AboutContent()
    }
}

@Composable
fun AboutContent() {
    val screenWidth = rememberScreenSize()
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (screenWidth > 1280) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(16.dp), // Espaciado opcional
                verticalAlignment = Alignment.CenterVertically, // Centrado vertical
                horizontalArrangement = Arrangement.Center // Centrado horizontal
            ) {
                AboutImage(screenWidth)
                Spacer(modifier = Modifier.width(150.dp)) // Espacio entre la imagen y el texto
                AboutMe()
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize(if (screenWidth >= 700) 0.8f else 1f)
                    .padding(16.dp), // Espaciado opcional
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AboutMe()
                Spacer(modifier = Modifier.height(20.dp)) // Espacio entre la imagen y el texto
                //AboutImage(screenWidth)
            }
        }

    }
}

@Composable
fun AboutImage(screenWidth: Int) {
    val imageSizeDp = (((screenWidth * 1.2) * 580) / 1920).dp
    // Aplicar límites al tamaño de la imagen
    val size = max(300.dp, min(580.dp, imageSizeDp))

    Box(
        modifier = Modifier.wrapContentWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .size(size),
            painter = painterResource(Res.Image.about),
            contentDescription = "About Image",
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun AboutMe() {
    var viewportEntered by remember { mutableStateOf(false) }
    var mouse by remember { mutableStateOf(false) }
    val grayscaleLevel by animateFloatAsState(
        targetValue = if (mouse) 0.9f else 0.5f,
        animationSpec = tween(
            durationMillis = 350, // Duración de la animación en milisegundos
            easing = FastOutSlowInEasing // Easing para una transición suave
        )
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .detectVisibility { isVisible ->
                viewportEntered = isVisible
            },
        verticalArrangement = Arrangement.Center
    ) {
        SectionTitle(section = Section.About)
        Text(
            modifier = Modifier
                .padding(
                    vertical = 25.dp
                )
                .pointerInput(Unit) {
                    awaitPointerEventScope {
                        while (true) {
                            val event = awaitPointerEvent()
                            when (event.type) {
                                PointerEventType.Enter -> mouse = true
                                PointerEventType.Exit -> mouse = false
                            }
                        }
                    }
                },
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Italic,
                color = Theme.Secondary.color.copy(alpha = grayscaleLevel)
            ),
            text = "Aqui va la descripcion de por que contratarme $Lorem"
        )
        Skills.entries.forEach { skills ->
            SkillBar(
                name = skills.title,
                index = skills.ordinal,
                percentage = skills.percentage,
                animatedPercentage = if (viewportEntered) (skills.percentage * 100).toInt() else 0
            )
        }
    }
}