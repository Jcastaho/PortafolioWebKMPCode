package org.straccion.project.sections

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.ktor.client.*
import io.ktor.client.engine.js.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.utils.io.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import org.straccion.project.components.ContactForm
import org.straccion.project.components.SectionTitle
import org.straccion.project.models.ContactFormData
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

    var statusMessage by remember { mutableStateOf("") }


    val client = remember { HttpClient(Js) }

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
                    .padding(top = 16.dp),
                text = "Enviar",
                onClick = {
                    GlobalScope.launch {
                        val response =  sendEmail(client, nombre, correo, mensaje)
                        statusMessage = response.toString()
                    }

                },
            )
            if (statusMessage.isNotEmpty()) {
                Text(
                    text = statusMessage,
                    color = if (statusMessage.startsWith("Error")) Color.Red else Color.Green,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
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


@OptIn(InternalAPI::class)
suspend fun sendEmail(
    client: HttpClient,
    name: String,
    email: String,
    message: String
) : String {  // Retorna un String
    val endpoint = "https://formspree.io/f/xovqzvbz"
    val formData = ContactFormData(name, email, message)  // Crear el objeto FormData

    return try {
        val response: HttpResponse = client.post(endpoint) {
            contentType(ContentType.Application.Json)
            body = Json.encodeToString(ContactFormData.serializer(), formData)  // Convertir a JSON manualmente
        }

        if (response.status.isSuccess()) {
            "Correo enviado satisfactoriamente"
        } else {
            "Error al enviar el formulario: ${response.status}"
        }
    } catch (e: Exception) {
        "Error: ${e.message}"
    }
}