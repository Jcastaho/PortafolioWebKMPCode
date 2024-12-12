package org.straccion.project.models

import androidx.compose.ui.graphics.Color

enum class Theme(
    val hex: String,
    val color: Color
) {
    Primary(
        hex = "#00A78E",
        color = Color(0xFF00A78E)
    ),
    Secondary(
        hex = "#121D34",
        color = Color(0xFF121D34)
    ),
    Gray(
        hex = "#CFCFCF",
        color = Color(0xFFCFCFCF)
    ),
    LightGray(
        hex = "#EDEDED",
        color = Color(0xFFEDEDED)
    ),
    LighterGray(
        hex = "#FFFFFF",
        color = Color(0xFFFCFCFC)
    );
}