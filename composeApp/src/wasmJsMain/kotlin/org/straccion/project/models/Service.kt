package org.straccion.project.models

import org.jetbrains.compose.resources.DrawableResource
import org.straccion.project.utils.Res

enum class Service(
    val icon: DrawableResource,
    val imageDesc: String,
    val title: String,
    val description: String
) {
    Android(
        icon = Res.Icon.android,
        imageDesc = "Icon",
        title = "Android Development",
        description = "Desarrollo de aplicaciones móviles nativas para Android utilizando Kotlin o Java, enfocándome en soluciones modernas, eficientes y escalables con tecnologías como Jetpack Compose, ViewModel y Retrofit."
    ),
    Web(
        icon = Res.Icon.web,
        imageDesc = "Icon web",
        title = "Web Development",
        description = "Creación de aplicaciones web dinámicas y modernas con Kobweb y Compose Multiplatform, garantizando interfaces responsivas, rápidas y consistentes en todos los dispositivos."
    ),
    Design(
        icon = Res.Icon.uxui,
        imageDesc = "Icon",
        title = "UX/UI Design",
        description = "Diseño de interfaces de usuario intuitivas y atractivas, enfocándome en la mejora de la experiencia del usuario (UX) y en la creación de prototipos funcionales para aplicaciones móviles y web."
    ),
    Multiplatform(
        icon = Res.Icon.multiplatform,
        imageDesc = "Icon",
        title = "Multiplatform Apps",
        description = "Creación de aplicaciones que funcionan en múltiples plataformas (Android, iOS, web) con una única base de código, asegurando consistencia y eficiencia."
    ),
    Architectures(
        icon = Res.Icon.architectures,
        imageDesc = "Icon",
        title = "Modern Architectures",
        description = "Diseño e implementación de arquitecturas escalables y modulares como Clean Architecture y MVVM para mejorar el mantenimiento y rendimiento de aplicaciones."
    ),
    Fullstack(
        icon =  Res.Icon.fullstack,
        imageDesc = "Icon",
        title = "Full-Stack Development",
        description = "Desarrollo de aplicaciones completas, manejando tanto el frontend (interfaz de usuario) como el backend (servidor, bases de datos y APIs)."
    )
}