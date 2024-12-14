package org.straccion.project.models

import org.jetbrains.compose.resources.DrawableResource
import org.straccion.project.utils.Res

enum class Achievements(
    val icon: DrawableResource,
    val number: Int,
    val description: String
) {
    Completed(
        icon = Res.Icon.multiplatform,
        number = 10,
        description = "Proyectos Completados"
    ),
    Active(
        icon = Res.Icon.multiplatform,
        number = 5,
        description = "Proyectos Activos"
    ),
    Satisfied(
        icon = Res.Icon.multiplatform,
        number = 8,
        description = "Clientes Satisfechos"
    ),
    Members(
        icon = Res.Icon.multiplatform,
        number = 10,
        description = "Miembros de Equipo"
    )
}