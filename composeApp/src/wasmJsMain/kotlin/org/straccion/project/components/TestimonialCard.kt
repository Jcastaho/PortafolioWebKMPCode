package org.straccion.project.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.straccion.project.models.Testimonial
import org.straccion.project.utils.Res
import org.straccion.project.utils.rememberScreenSize

@Composable
fun TestimonialCard(
    testimonial: Testimonial
) {
    val screenWidth = rememberScreenSize()

    val imageSizeDp = (((screenWidth * 1.3) * 350) / 1920).dp

    // Aplicar límites al tamaño de la imagen
    val size = max(120.dp, min(180.dp, imageSizeDp))


    Card(
        modifier = Modifier
            .width(550.dp)
            .padding(8.dp)
            .shadow(0.dp),
        shape = RoundedCornerShape(
            topEnd = 16.dp, topStart = 16.dp,
            bottomStart = 16.dp
        ),
        elevation = 0.dp

    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(testimonial.image),
                contentDescription = null,
                modifier = Modifier
                    .size(size)
                    .clip(CircleShape)
            )
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    repeat(5) {
                        Icon(
                            painter = painterResource(Res.Icon.star),
                            contentDescription = null,
                            modifier = Modifier.size(18.dp),
                            tint = Color(0xFFFFD700)
                        )
                    }
                }
                Text(
                    style = TextStyle(
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Bold
                    ),
                    text = testimonial.fullName,
                    fontSize = 22.sp,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    style = TextStyle(
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Normal,
                        color = Color.LightGray
                    ),
                    text = testimonial.profession,
                    fontSize = 18.sp,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                    ),
                    text = testimonial.review,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}
