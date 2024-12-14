package org.straccion.project

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import org.straccion.project.sections.*

@Composable
fun App() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            MainSection()
            AboutSection()
            ServiceSection()
            PortafolioSection()
            AchievementsSection()
        }
    }
}







//    MaterialTheme {
//        Column(
//            modifier = Modifier
//                .fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Pages()
//        }
//    }

//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .fillMaxSize(),
//        verticalArrangement = Arrangement.Center
//    ) {
//        // Secciones en orden
//
//        MainSection()
//        MainSection()
//        AboutSection()
//
//    }

//    MaterialTheme {
//        var showContent by remember { mutableStateOf(false) }
//
//    }



//
//import androidx.compose.animation.AnimatedVisibility
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.material.Button
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Text
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import org.jetbrains.compose.resources.painterResource
//
//import practica_compose.composeapp.generated.resources.Res
//import practica_compose.composeapp.generated.resources.compose_multiplatform
//
//@Composable
//fun App() {
//    MaterialTheme {
//        var showContent by remember { mutableStateOf(false) }
//        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//            Button(onClick = { showContent = !showContent }) {
//                Text("Click me!")
//            }
//            AnimatedVisibility(showContent) {
//                val greeting = remember { Greeting().greet() }
//                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                    Image(painterResource(Res.drawable.compose_multiplatform), null)
//                    Text("Compose: $greeting")
//                }
//            }
//        }
//    }
//}