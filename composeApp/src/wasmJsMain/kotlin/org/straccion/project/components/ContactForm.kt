package org.straccion.project.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
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
