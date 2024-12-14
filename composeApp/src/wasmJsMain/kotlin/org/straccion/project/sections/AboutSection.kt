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

@Composable
fun AboutSection() {
    val screenHeight = TamanoAuto()
    Box(
        modifier = Modifier
            .height(screenHeight)
            .padding(top = 100.dp, start = 25.dp, end = 25.dp),
        contentAlignment = Alignment.Center
    ) {
        AboutContent()
    }
}

@Composable
fun AboutContent() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxWidth(),
            columns = GridCells.Fixed(2),
        ) {
            item() {
                AboutImage()
            }
            item() {
                AboutMe()
            }
        }
    }
}

@Composable
fun AboutImage() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(
                    top = 35.dp,
                    end = 35.dp,
                    start = 35.dp
                ),
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