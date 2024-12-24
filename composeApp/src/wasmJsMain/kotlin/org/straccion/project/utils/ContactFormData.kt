package org.straccion.project.utils

import kotlinx.serialization.Serializable


@Serializable
data class ContactFormData(
    val nombre: String,
    val email: String,
    val mensaje: String
)
