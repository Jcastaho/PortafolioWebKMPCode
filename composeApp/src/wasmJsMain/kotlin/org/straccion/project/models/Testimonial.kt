package org.straccion.project.models

import org.jetbrains.compose.resources.DrawableResource
import org.straccion.project.utils.Constants.Lorem
import org.straccion.project.utils.Res

enum class Testimonial(
    val image: DrawableResource,
    val fullName: String,
    val profession: String,
    val review: String
) {
    First(
        image = Res.Image.mainImage,
        fullName = "Pepe 1",
        profession = "Web Designer",
        review = Lorem
    ),
    Second(
        image = Res.Image.mainImage,
        fullName = "Pepe 2",
        profession = "Web Designer",
        review = Lorem
    ),
    Third(
        image = Res.Image.logo,
        fullName = "Pepe 3",
        profession = "Web Designer",
        review = Lorem
    ),
    Fourth(
        image = Res.Image.logo,
        fullName = "Pepe 4",
        profession = "Web Designer",
        review = Lorem
    ),
    Fifth(
        image = Res.Image.logo,
        fullName = "Pepe 5",
        profession = "Web Designer",
        review = Lorem
    ),
    Sixth(
        image = Res.Image.logo,
        fullName = "Pepe 6",
        profession = "Web Designer",
        review = Lorem
    )
}