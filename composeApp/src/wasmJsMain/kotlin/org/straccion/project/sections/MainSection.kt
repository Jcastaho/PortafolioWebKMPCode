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
import androidx.compose.ui.zIndex
import kotlinx.browser.window
import org.jetbrains.compose.resources.painterResource
import org.straccion.project.components.*
import org.straccion.project.models.Theme
import org.straccion.project.utils.Constants.Lorem
import org.straccion.project.utils.Res
import org.straccion.project.utils.TamanoAuto

@Composable
fun MainSection() {
    var screenWidth by remember { mutableStateOf(window.innerWidth) }

    LaunchedEffect(Unit) {
        window.addEventListener("resize", {
            screenWidth = window.innerWidth
        })
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(954.dp),
        contentAlignment = Alignment.Center // Centra todo su contenido
    ) {
        MainBackground()
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .wrapContentHeight(), // Ajusta la altura al contenido
            contentAlignment = Alignment.Center
        ) {
            if (screenWidth > 1270) {
                MainContent()
                LargeScreenLayout()
            } else {
                MainContentSmall()
                SmallScreenLayout()
            }
        }
    }
}

//fondo
@Composable
fun MainBackground() {
    Image(
        painter = painterResource(Res.Image.background),
        contentDescription = "Background Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}

//header con logo
@Composable
fun MainContent() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()
    }
}

@Composable
fun MainContentSmall() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp, start = 10.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            LeftSide()
        }
    }
}

@Composable
fun LargeScreenLayout() {
    Row(
        modifier = Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween, // Espacio específico entre elementos
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .wrapContentWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SocialBar(
                modifier = Modifier.padding(26.dp),
                isVertical = true
            )
            MainText(breakpoint = 1300) // Textos a la izquierda
        }
        MainImage(1300) // Imagen a la derecha
    }
}

@Composable
fun SmallScreenLayout() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 80.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MainText(breakpoint = 480) // Textos encima
        Spacer(modifier = Modifier.height(16.dp))
        MainImage(breakpoint = 1000) // Imagen más pequeña debajo
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
                    fontSize = if (breakpoint >= 1270) 58.sp else 48.sp,
                    fontWeight = FontWeight.Normal,
                    color = Theme.Primary.color,
                )
            )
            Text(
                modifier = Modifier
                    .padding(top = 20.dp),
                text = "Juan David Castaño",
                style = TextStyle(
                    fontSize = if (breakpoint >= 1270) 48.sp else 38.sp,
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
fun MainImage(breakpoint: Int) {
    var isHovered by remember { mutableStateOf(false) }
    val grayscaleLevel by animateFloatAsState(
        targetValue = if (isHovered) 0f else 1f,
        animationSpec = tween(
            durationMillis = 500, // Duración de la animación en milisegundos
            easing = FastOutSlowInEasing // Easing para una transición suave
        )
    )

    Column(
        modifier = Modifier.width(550.dp).height(550.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(if (breakpoint >= 1270) 1f else 0.85f)
                .offset(x = if (breakpoint >= 1270) (-50).dp else 15.dp)
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