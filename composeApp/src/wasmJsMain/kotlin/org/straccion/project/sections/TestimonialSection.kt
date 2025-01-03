package org.straccion.project.sections

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import org.straccion.project.components.SectionTitle
import org.straccion.project.components.TestimonialCard
import org.straccion.project.models.Section
import org.straccion.project.models.Testimonial
import org.straccion.project.models.Theme
import org.straccion.project.utils.rememberScreenSize

@Composable
fun TestimonialSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .padding(vertical = 50.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TestimonialContent()
    }
}

@Composable
fun TestimonialContent() {

    val screenWidth = rememberScreenSize()

    val testimonials = Testimonial.entries.toList()
    val numberOfTestimonialsToShow = 2
    var currentIndex by remember { mutableStateOf(0) }
    SectionTitle(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 25.dp),
        section = Section.Testimonial,
        alignment = Alignment.CenterHorizontally
    )
    Box(
        modifier = Modifier.fillMaxSize()
            .padding(vertical = 32.dp),
        contentAlignment = Alignment.Center
    ) {
        Crossfade(
            targetState = currentIndex,
            animationSpec = tween(durationMillis = 500) // Duración de la animación
        ) { targetIndex ->
            if (screenWidth > 1130){
                LazyRow(
                    modifier = Modifier
                        .wrapContentSize() // Tamaño ajustado al contenido
                        .align(Alignment.Center)
                        .padding(bottom = 50.dp),
                    userScrollEnabled = false
                ) {
                    items(
                        items = testimonials.subList(
                            targetIndex,
                            (targetIndex + numberOfTestimonialsToShow).coerceAtMost(testimonials.size)
                        )
                    ) { testimonial ->
                        TestimonialCard(testimonial = testimonial)
                    }
                }
            }else{
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.Center)
                        .padding(bottom = 50.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    testimonials.subList(targetIndex,
                        (targetIndex + numberOfTestimonialsToShow).coerceAtMost(testimonials.size)
                    ).forEach { testimonial ->
                        TestimonialCard(testimonial = testimonial)
                    }
                }

            }
        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(top = 50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            repeat(testimonials.size / numberOfTestimonialsToShow) { index ->
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(
                            if (index == currentIndex / numberOfTestimonialsToShow) Theme.Primary.color
                            else MaterialTheme.colors.onSurface.copy(alpha = 0.12f)
                        )
                        .clickable {
                            currentIndex = index * numberOfTestimonialsToShow
                        }
                )
            }
        }
    }
}

