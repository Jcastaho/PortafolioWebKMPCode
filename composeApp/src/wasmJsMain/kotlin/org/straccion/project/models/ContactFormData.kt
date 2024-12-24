package org.straccion.project.models

import kotlinx.serialization.Serializable


@Serializable
data class ContactFormData(
    val nombre: String,
    val email: String,
    val mensaje: String
)
