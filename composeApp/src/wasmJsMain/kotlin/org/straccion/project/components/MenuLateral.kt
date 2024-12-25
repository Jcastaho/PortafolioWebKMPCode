package org.straccion.project.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import org.straccion.project.models.Section
import org.straccion.project.models.Theme
import org.straccion.project.utils.rememberScreenSize

@Composable
fun MenuLateral(
    onClose: () -> Unit,
    onSectionClick: (String) -> Unit
) {
    val screenWidth = rememberScreenSize()
    val tamaño = screenWidth / 2

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f))
            .clickable { onClose() }
    ) {
        // Menú con z-index mayor
        Box(
            modifier = Modifier
                .width(tamaño.dp)
                .fillMaxHeight()
                .background(Color.Black.copy(alpha = 0.9f))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(16.dp)
            ) {
                Text(
                    modifier = Modifier.padding(start = 10.dp),
                    text = "Menú",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
                Spacer(modifier = Modifier.height(40.dp))

                Section.values().take(8).forEach { section ->
                    menus(
                        section.title,
                        path = section.path,
                        modifier = Modifier.padding(bottom = 25.dp, start = 10.dp),
                        sectionId = section.id,
                        onSectionClick = { id ->
                            onSectionClick(id)
                            onClose
                        },
                        normalColor = Color.White
                    )
                }
            }
        }
    }
}