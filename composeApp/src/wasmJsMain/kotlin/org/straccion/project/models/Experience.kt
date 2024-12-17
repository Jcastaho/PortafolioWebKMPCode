package org.straccion.project.models

import org.straccion.project.utils.Constants.Lorem

enum class Experience(
    val number: String,
    val jobPosition: String,
    val description: String,
    val company: String,
    val from: String,
    val to: String
) {
    First(
        number = "01",
        jobPosition = "Kotlin Multi-Platform Developer",
        description = Lorem,
        company = "Google",
        from = "Febrero",
        to = "Ahora"
    ),
    Second(
        number = "02",
        jobPosition = "Mobile Developer",
        description = Lorem,
        company = "Facebook",
        from = "Enero 2021",
        to = "Octubre 2021"
    ),
    Third(
        number = "03",
        jobPosition = "Freelancer",
        description = Lorem,
        company = "Netflix",
        from = "Enero 2020",
        to = "Diciembre 2020"
    )
}