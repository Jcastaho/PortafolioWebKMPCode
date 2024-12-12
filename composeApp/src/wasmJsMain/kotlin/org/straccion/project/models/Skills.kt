package org.straccion.project.models

enum class Skills(
    val title: String,
    val percentage: Float
) {
    Kotlin(
        title = "Kotlin",
        percentage = 0.9f
    ),
    Compose(
        title = "Jetpack Compose",
        percentage = 0.9f
    ),
    Java(
        title = "Java",
        percentage = 0.8f
    ),
    Firebase(
        title = "Firebase",
        percentage = 0.8f
    ),
    Sqlserver(
        title = "SQL Server",
        percentage = 0.75f
    ),
    MvvmClean(
        title = "MVVM y Clean Architecture",
        percentage = 0.85f
    ),
    Git(
        title = "GitHub",
        percentage = 0.75f
    ),
}