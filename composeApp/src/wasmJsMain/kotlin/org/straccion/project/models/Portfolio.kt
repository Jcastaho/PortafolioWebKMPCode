package org.straccion.project.models

import org.jetbrains.compose.resources.DrawableResource
import org.straccion.project.utils.Constants.Lorem
import org.straccion.project.utils.Res

enum class Portfolio(
    val image: DrawableResource,
    val title: String,
    val description: String
) {
    One(
        image = Res.Image.portfolio1,
        title = "Mi Moto ideal (Kotlin)",
        description = "Mi Moto ideal realizada en Kotlin Jetpack Compose $Lorem"
    ),
    Two(
        image = Res.Image.portfolio2,
        title = "Mi Moto ideal (Java)",
        description = "Mi Moto ideal realizada en Java $Lorem"
    ),
    Three(
        image = Res.Image.portfolio3,
        title = "ej3",
        description = "ej3 $Lorem"
    ),
    Four(
        image = Res.Image.portfolio4,
        title = "ej4",
        description = "ej4"
    ),
    Five(
        image = Res.Image.portfolio5,
        title = "ej5",
        description = "ej5"
    )
}