package org.straccion.project.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.straccion.project.components.ContactForm
import org.straccion.project.components.SectionTitle
import org.straccion.project.models.Section
import org.straccion.project.models.Theme

@Composable
fun ContacSection() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(vertical = 50.dp, horizontal = 50.dp),
        verticalArrangement = Arrangement.Center
    ) {
        ContacContent()
    }
}

@Composable
fun ContacContent() {
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var mensaje by remember { mutableStateOf("") }
    SectionTitle(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 25.dp),
        section = Section.Contact,
        alignment = Alignment.CenterHorizontally
    )
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ContactForm(
                modifier = Modifier.width(380.dp)
                    .padding(vertical = 5.dp),
                value = nombre,
                label = "Nombre Completo",
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                onValueChange = { nombre = it }
            )
            ContactForm(
                modifier = Modifier.width(380.dp)
                    .padding(vertical = 5.dp),
                value = correo,
                label = "Correo",
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Email
                ),
                onValueChange = { correo = it }
            )
            ContactForm(
                modifier = Modifier.width(380.dp)
                    .height(300.dp)
                    .padding(vertical = 5.dp),
                value = mensaje,
                label = "Escriba el Mensaje",
                singleLine = false,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done,
                ),
                onValueChange = { mensaje = it }
            )
            DefaultButton(
                modifier = Modifier
                    .width(150.dp)
                    .padding(top = 16.dp)
                    .background(
                        Color.Transparent
                    )
                    .shadow(0.dp)
                    .align(Alignment.CenterHorizontally),
                text = "Enviar",
                onClick = {
                },
            )
        }
    }
}

@Composable
fun DefaultButton(
    modifier: Modifier,
    text: String,
    onClick: () -> Unit,
    fontSize: Int = 14,
) {
    Button(
        modifier = modifier,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Theme.Primary.color,
            contentColor = Color.White
        ),
        contentPadding = PaddingValues(), // Sin relleno interno
    ) {
        Text(
            text,
            fontSize = fontSize.sp
        )
    }
}