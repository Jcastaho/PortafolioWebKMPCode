package org.straccion.project

import androidx.compose.animation.core.*
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.zIndex
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.straccion.project.components.LeftSide
import org.straccion.project.sections.*
import org.straccion.project.utils.SectionRefs
import org.straccion.project.utils.rememberScreenSize

@Composable
fun App() {
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()
    val screenWidth = rememberScreenSize()

    // Creamos una función común para el manejo del scroll
    val handleSectionClick: (String) -> Unit = { sectionId ->
        scope.launch {
            SectionRefs.getOffset(sectionId)?.let { offset ->
                scrollState.animateScrollTo(
                    value = offset.toInt(),
                    animationSpec = tween(
                        durationMillis = 1000,
                        easing = FastOutSlowInEasing
                    )
                )
            }
        }
    }


    // Estado para detectar la dirección del scroll
    val previousScrollValue = remember { mutableStateOf(0) }
    val isScrollingUp = remember { mutableStateOf(true) }

    // Estado animado para la visibilidad
    val menuVisibility by animateFloatAsState(
        targetValue = if (isScrollingUp.value) 1f else 0f,
        animationSpec = tween(
            durationMillis = 300,
            easing = FastOutSlowInEasing
        )
    )

    // Efecto para detectar la dirección del scroll
    LaunchedEffect(scrollState.value) {
        isScrollingUp.value = scrollState.value <= previousScrollValue.value
        previousScrollValue.value = scrollState.value
    }

    MaterialTheme {
        Box(modifier = Modifier.fillMaxSize()) { // Contenedor principal
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
            ) {
                MainSection(
                    onSectionClick = handleSectionClick,
                    modifier = Modifier.onGloballyPositioned { coordinates ->
                        SectionRefs.setOffset("home", coordinates.positionInRoot().y)
                    }
                )

                val aboutOffset = remember { mutableStateOf(false) }
                AboutSection(
                    viewportEntered = aboutOffset.value,
                    modifier = Modifier.onGloballyPositioned { coordinates ->
                        SectionRefs.setOffset("about", coordinates.positionInRoot().y)
                    }
                )
                LaunchedEffect(scrollState.value) {
                    // Calculamos el 25% de 954.dp
                    val quarterScreen = 954f * 0.25  // esto sería aproximadamente 238.5

                    // Verificamos si el scroll ha superado el 25% de la pantalla inicial
                    val hasScrolledQuarter = scrollState.value >= quarterScreen

                    if (hasScrolledQuarter) {
                        aboutOffset.value = true
                    }
                }
                ServiceSection(
                    modifier = Modifier.onGloballyPositioned { coordinates ->
                        SectionRefs.setOffset("service", coordinates.positionInRoot().y)
                    }
                )
                PortafolioSection(
                    modifier = Modifier.onGloballyPositioned { coordinates ->
                        SectionRefs.setOffset("portfolio", coordinates.positionInRoot().y)
                    }
                )
                AchievementsSection(
                    modifier = Modifier.onGloballyPositioned { coordinates ->
                        SectionRefs.setOffset("achievements", coordinates.positionInRoot().y)
                    }
                )
                TestimonialSection(
                    modifier = Modifier.onGloballyPositioned { coordinates ->
                        SectionRefs.setOffset("testimonial", coordinates.positionInRoot().y)
                    }
                )
                ExperienceSection(
                    modifier = Modifier.onGloballyPositioned { coordinates ->
                        SectionRefs.setOffset("experience", coordinates.positionInRoot().y)
                    }
                )
                ContacSection(
                    modifier = Modifier.onGloballyPositioned { coordinates ->
                        SectionRefs.setOffset("contact", coordinates.positionInRoot().y)
                    }
                )
                FooterSection(
                    onSectionClick = handleSectionClick
                )
            }
            if (screenWidth < 1200) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .zIndex(99f)
                        .graphicsLayer {
                            alpha = menuVisibility  // Controla la opacidad
                            translationY = (1f - menuVisibility) * -50f  // Desliza hacia arriba/abajo
                        }
                ) {
                    LeftSide(
                        visible = true,
                        onSectionClick = handleSectionClick
                    )
                }
            }
        }
    }
}
