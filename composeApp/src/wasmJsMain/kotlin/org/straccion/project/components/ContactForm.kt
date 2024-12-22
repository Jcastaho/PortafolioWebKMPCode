package org.straccion.project.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import org.straccion.project.models.Theme

@Composable
fun ContactForm(
    modifier: Modifier,
    value: String,
    onValueChange: (value: String) -> Unit,
    label: String,
    singleLine: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default, // KeyboardOptions opcional
) {
    val textSelectionColors = TextSelectionColors(
        handleColor = Theme.LightGray.color,
        backgroundColor = Theme.LightGray.color
    )

    CompositionLocalProvider(
        LocalTextSelectionColors provides textSelectionColors
    ) {
        OutlinedTextField(
            modifier = modifier,
            value = value,
            onValueChange = onValueChange,
            label = { Text(label ?: "") },
            singleLine = singleLine,
            keyboardOptions = keyboardOptions,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Theme.Primary.color,
                focusedLabelColor = Theme.Primary.color,
                unfocusedBorderColor = Theme.Primary.color,
                unfocusedLabelColor = Theme.Secondary.color
            )
        )
    }
}
