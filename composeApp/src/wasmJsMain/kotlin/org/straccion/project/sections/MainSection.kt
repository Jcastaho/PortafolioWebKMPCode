package org.straccion.project.sections

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.straccion.project.components.*
import org.straccion.project.models.Theme
import org.straccion.project.utils.Constants.Lorem
import org.straccion.project.utils.Res
import org.straccion.project.utils.rememberScreenSize

@Composable
fun MainSection(
    onSectionClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val screenWidth = rememberScreenSize()
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(954.dp),
        contentAlignment = Alignment.Center // Centra todo su contenido
    ) {
        MainBackground()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(), // Ajusta la altura al contenido
            contentAlignment = Alignment.Center
        ) {
            if (screenWidth > 1200) {
                MainContent(onSectionClick)
                LargeScreenLayout(screenWidth)
            } else {
                MainContentSmall()
                SmallScreenLayout(screenWidth)
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
fun MainContent(onSectionClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(
            onSectionClick,
            modifier = Modifier.fillMaxWidth(0.9f)
        )
    }
}

@Composable
fun MainContentSmall() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {
            LeftSide(visible = true)
        }
    }
}

@Composable
fun LargeScreenLayout(screenWidth: Int) {
    Row(
        modifier = Modifier
            .fillMaxSize(0.9f)
            .padding(top = 100.dp),
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
            MainText(screenWidth) // Textos a la izquierda
        }
        MainImage(screenWidth) // Imagen a la derecha
    }
}

@Composable
fun SmallScreenLayout(screenWidth: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize(0.9f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MainText(breakpoint = 480) // Textos encima
        Spacer(modifier = Modifier.height(16.dp))
        MainImage(screenWidth) // Imagen más pequeña debajo
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
                    fontSize =
                    if (breakpoint >= 800) 65.sp
                    else 55.sp,
                    fontWeight = FontWeight.Normal,
                    color = Theme.Primary.color,
                )
            )
            Text(
                modifier = Modifier
                    .padding(top = 20.dp),
                text = "Juan David Castaño",
                style = TextStyle(
                    fontSize =
                    if (breakpoint >= 800) 58.sp
                    else 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = Theme.Secondary.color,
                )
            )
            Text(
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 5.dp),
                text = "Mobile & Web Developer Kotlin",
                style = TextStyle(
                    fontSize = if (breakpoint >= 800) 24.sp else 18.sp,
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
                        fontSize = if (breakpoint >= 800) 18.sp else 16.sp,
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
    val imageSizeDp = (((breakpoint * 1.3) * 600) / 1920).dp

    // Aplicar límites al tamaño de la imagen
    val size = max(300.dp, min(600.dp, imageSizeDp))

    Column(
        modifier = Modifier
            .size(size),
         //   .offset(x = if (breakpoint > 1280) (-80).dp else (-20).dp),
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
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