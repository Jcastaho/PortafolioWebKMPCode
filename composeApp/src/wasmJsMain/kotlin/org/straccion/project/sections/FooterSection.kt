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

@Composable
fun FooterSection(){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Theme.LightGray.color)
            .padding(vertical = 50.dp),
        verticalArrangement = Arrangement.Center
    ) {
        FooterContent()
    }
}

@Composable
fun FooterContent(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .wrapContentWidth()
        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(60.dp),
                painter = painterResource(Res.Image.logo),
                contentDescription = "Logo Image",
                contentScale = ContentScale.Crop
            )
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
            Spacer(modifier = Modifier.height(10.dp))
            SocialBar(
                modifier = Modifier.padding(16.dp).align(Alignment.CenterHorizontally),
                isVertical = false
            )
        }
    }
}
