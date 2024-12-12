package org.straccion.project.sections

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.straccion.project.components.Header
import org.straccion.project.models.Theme
import org.straccion.project.utils.Constants.Lorem
import org.straccion.project.utils.Res
import org.straccion.project.utils.TamanoAuto

@Composable
fun MainSection() {
    val screenHeight = TamanoAuto()

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(screenHeight)
    ) {
        MainBackground()
        MainContent()
    }
}

@Composable
fun MainBackground() {
    Image(
        painter = painterResource(Res.Image.background),
        contentDescription = "Background Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun MainContent() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxWidth(),
                columns = GridCells.Fixed(2),
            ) {
                item() {
                    Column(
                        modifier = Modifier.padding(top = 80.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        MainText(800)
                    }
                }
                item() {
                    MainImage()
                }
            }
        }
    }
}


@Composable
fun MainText(breakpoint: Int) {
    var isHovered by remember { mutableStateOf(false) }
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "Hola, yo soy",
                style = TextStyle(
                    fontSize = if (breakpoint >= 768) 58.sp else 48.sp,
                    fontWeight = FontWeight.Normal,
                    color = Theme.Primary.color,
                )
            )
            Text(
                modifier = Modifier
                    .padding(top = 20.dp),
                text = "Juan David Castaño",
                style = TextStyle(
                    fontSize = if (breakpoint >= 768) 48.sp else 38.sp,
                    fontWeight = FontWeight.Bold,
                    color = Theme.Secondary.color,
                )
            )
            Text(
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 5.dp),
                text = "Mobile & Web Developer Kotlin",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Theme.Secondary.color,
                )
            )
            Box(
                modifier = Modifier
                    .padding(bottom = 25.dp) // Equivalente a `margin(bottom = 25.px)`
                    .widthIn(max = 400.dp) // Define un ancho máximo de 400px
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 10.dp, bottom = 5.dp),
                    text = "Mi descripcion $Lorem",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Normal,
                        color = Theme.Secondary.color,
                    )
                )
            }
        }
    }
}

@Composable
fun MainImage() {
    var isHovered by remember { mutableStateOf(false) }
    val grayscaleLevel by animateFloatAsState(
        targetValue = if (isHovered) 0f else 1f,
        animationSpec = tween(
            durationMillis = 500, // Duración de la animación en milisegundos
            easing = FastOutSlowInEasing // Easing para una transición suave
        )
    )

    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(0.8f)
                .pointerInput(Unit) {
                    awaitPointerEventScope {
                        while (true) {
                            val event = awaitPointerEvent()
                            when (event.type) {
                                PointerEventType.Enter -> isHovered = true
                                PointerEventType.Exit -> isHovered = false
                            }
                        }
                    }
                },
            colorFilter = ColorFilter.colorMatrix(
                ColorMatrix().apply {
                    setToSaturation(grayscaleLevel)
                }
            ),
            painter = painterResource(Res.Image.mainImage),
            contentDescription = "Main Image",
            contentScale = ContentScale.Crop
        )
    }
}