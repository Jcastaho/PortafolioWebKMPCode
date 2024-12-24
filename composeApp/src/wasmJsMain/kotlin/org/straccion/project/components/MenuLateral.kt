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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import org.straccion.project.utils.rememberScreenSize

@Composable
fun MenuLateral(
    onClose: () -> Unit
) {
    val screenWidth = rememberScreenSize()
    val tamaño = screenWidth / 2
    Box(
        modifier = Modifier
            .width(tamaño.dp)
            .fillMaxHeight()
            .zIndex(1f)
    ) {
        // Fondo oscuro
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f))
                .clickable { onClose() } // Cierra el menú al hacer clic en el fondo
        )

        // Contenedor del menú
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .width(200.dp) // Ancho del menú
                .background(Color.White) // Color de fondo
                .padding(16.dp)
                .align(Alignment.CenterStart) // Alineación izquierda
        ) {
            Text("Menú", style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold))
            Spacer(modifier = Modifier.height(16.dp))

            // Opciones del menú
            MenuItem("Inicio", onClose)
            MenuItem("Servicios", onClose)
            MenuItem("Portafolio", onClose)
            MenuItem("Contacto", onClose)

            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = onClose) {
                Text("Cerrar Menú")
            }
        }
    }
}


@Composable
fun MenuItem(text: String, onClick: () -> Unit) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick)
            .background(Color(0xFFDDDDDD), shape = RoundedCornerShape(4.dp))
            .padding(8.dp),
        style = TextStyle(fontSize = 16.sp)
    )
}