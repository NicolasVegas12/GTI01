package com.minenick.timemanagmentproject.app.components.inputs

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.minenick.timemanagmentproject.app.theme.TimeManagmentProjectTheme

@Composable
fun OutlinedTextInput(
    modifier: Modifier=Modifier,
    name: String,
    text: String,
    type: KeyboardType = KeyboardType.Text,
    onTextFieldChanged: (String) -> Unit,
    singleLine:Boolean = false
) {
    OutlinedTextField(
        value = text,
        modifier = modifier
            .fillMaxWidth()
            .testTag(name),
        onValueChange = onTextFieldChanged,
        keyboardOptions = KeyboardOptions(keyboardType = type),
        singleLine = singleLine,
        placeholder = {
            Text(
                text = name,
                color = MaterialTheme.colorScheme.outline,
                style = MaterialTheme.typography.labelMedium
            )
        },
        shape = RoundedCornerShape(16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = MaterialTheme.colorScheme.onBackground,
            unfocusedLabelColor = MaterialTheme.colorScheme.outline,
            focusedBorderColor = MaterialTheme.colorScheme.onBackground,
            unfocusedBorderColor = MaterialTheme.colorScheme.outline,
        )

    )
}

@Preview(name = "LightMode")
@Preview(name = "NightMode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewOutlinedTextInput() {
    TimeManagmentProjectTheme {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)){

            OutlinedTextInput(text = "Nicolas", name = "Nombre de Invitado", onTextFieldChanged = {})
        }
    }
}