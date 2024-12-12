package org.straccion.project.models

enum class Section(
    val id: String,
    val title: String,
    val subtitle: String,
    val path: String
) {
    Home(
        id = "home",
        title = "Inicio",
        subtitle = "",
        path = "#home"
    ),
    About(
        id = "about",
        title = "Acerca de mí",
        subtitle = "¿Por qué contratarme?",
        path = "#about"
    ),
    Service(
        id = "service",
        title = "Servicios",
        subtitle = "Soy bueno en",
        path = "#service"
    ),
    Portfolio(
        id = "portfolio",
        title = "Portafolio",
        subtitle = "My Work",
        path = "#portfolio"
    ),
    Experience(
        id = "experience",
        title = "Experiencia",
        subtitle = "Work Experience",
        path = "#experience"
    ),
    Contact(
        id = "contact",
        title = "Contactame",
        subtitle = "Get in Touch",
        path = "#contact"
    ),
    Testimonial(
        id = "testimonial",
        title = "Testimonial",
        subtitle = "Happy Customers",
        path = "#testimonial"
    ),
    Archievements(
        id = "archievements",
        title = "Archievements",
        subtitle = "Personal Archievements",
        path = "#archievements"
    ),

}