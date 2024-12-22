package org.straccion.project.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.straccion.project.components.SocialBar
import org.straccion.project.components.menus
import org.straccion.project.models.Section
import org.straccion.project.models.Theme
import org.straccion.project.utils.Res
import org.straccion.project.utils.rememberScreenSize

@Composable
fun FooterSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth() // Cambiado de fillMaxHeight a fillMaxWidth
            .background(Theme.LightGray.color)
            .padding(vertical = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally, // Añadido para mejor centrado
        verticalArrangement = Arrangement.Center
    ) {
        FooterContent()
    }
}

@Composable
fun FooterContent() {
    val screenWidth = rememberScreenSize()

    Column(
        modifier = Modifier
            .wrapContentWidth()
            .padding(horizontal = 16.dp), // Asegura que el contenido no toque los bordes
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(80.dp),
            painter = painterResource(Res.Image.logo),
            contentDescription = "Logo Image",
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(32.dp))
        if (screenWidth > 750) {
            Row(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(top = 30.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Section.values().take(6).forEach { section ->
                    menus(
                        section.title,
                        path = section.path
                    )
                }
            }
        } else {
            Section.values().take(6).forEach { section ->
                menus(
                    section.title,
                    path = section.path,
                    modifier = Modifier.offset(x = 18.dp).padding(bottom = 10.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(32.dp))

        SocialBar(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally),
            isVertical = false
        )
    }
}