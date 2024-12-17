package org.straccion.project.components

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import org.straccion.project.models.Theme

@Composable
fun SkillBar(
    name: String,
    index: Int,
    progressBarHeight: Dp = 5.dp,
    percentage: Float,
    animatedPercentage: Int
) {
    val animatedWidth by animateFloatAsState(
        targetValue = if (animatedPercentage > 0) percentage else 0f,
        animationSpec = tween(
            durationMillis = 2200,
            delayMillis = 260 * index,
            easing = LinearOutSlowInEasing
        )
    )

    val animatedPercentageValue by animateIntAsState(
        targetValue = animatedPercentage,
        animationSpec = tween(
            durationMillis = 2200,
            delayMillis = 270 * index,
            easing = LinearOutSlowInEasing
        )
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                bottom = 15.dp,
                top = 5.dp
            )
    ) {
        Text(
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = Theme.Secondary.color
            ),
            text = name,
            modifier = Modifier.padding(bottom = 5.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Theme.LightGray.color)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(animatedWidth)
                    .height(progressBarHeight)
                    .background(Theme.Primary.color)
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = Theme.Secondary.color
            ),
            text = "$animatedPercentageValue%",
            modifier = Modifier.align(Alignment.End)
        )
    }
}