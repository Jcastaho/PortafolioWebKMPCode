package org.straccion.project.utils

import practica_compose.composeapp.generated.resources.*
import practica_compose.composeapp.generated.resources.Res
import practica_compose.composeapp.generated.resources.androide
import practica_compose.composeapp.generated.resources.background
import practica_compose.composeapp.generated.resources.web_developmen

object Constants {
    const val WEBSITE = "https://github.com/Jcastaho"
    const val FONT_FAMILY = "Roboto"
    const val Lorem =
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat"
}

object Res {
    object Image {
        val background = Res.drawable.background
        val logo = Res.drawable.logocv
        val mainImage = Res.drawable.muneco_imagen
        val about = Res.drawable.muneco_imagen
        val portfolio1 = Res.drawable.porfolio
        val portfolio2 = Res.drawable.porfolio
        val portfolio3 = Res.drawable.porfolio
        val portfolio4 = Res.drawable.porfolio
        val portfolio5 = Res.drawable.porfolio
    }

    object Icon {
        val android = Res.drawable.androide
        val web = Res.drawable.web_developmen
        val uxui = Res.drawable.ux_ui
        val architectures = Res.drawable.clean_architecture
        val multiplatform = Res.drawable.multiplatform
        val fullstack = Res.drawable.fullstack
        val link = Res.drawable.compartir
        val star = Res.drawable.estrella
        val menu = Res.drawable.menu
    }
}