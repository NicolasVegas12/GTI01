package com.minenick.timemanagmentproject.app.components.inputs

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.minenick.timemanagmentproject.app.theme.TimeManagmentProjectTheme

@Composable
fun PasswordOutlinedTextInput(
    modifier: Modifier = Modifier,
    name: String,
    text: String,
    type: KeyboardType = KeyboardType.Password,
    onTextFieldChanged: (String) -> Unit
) {
    var passwordVisibility by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = text,
        onValueChange = onTextFieldChanged,
        modifier = modifier
            .fillMaxWidth()
            .testTag(name),
        keyboardOptions = KeyboardOptions(keyboardType = type),
        singleLine = true,
        maxLines = 1,
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
        ),
        trailingIcon = {
            val icon = if (passwordVisibility) {
                Icons.Outlined.VisibilityOff
            } else {
                Icons.Outlined.Visibility
            }
            IconButton(onClick = { passwordVisibility = !passwordVisibility },modifier = Modifier.testTag(name+"button")) {
                Icon(imageVector = icon, contentDescription = null,tint = MaterialTheme.colorScheme.onBackground)
            }
        },
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Preview(name = "Light Mode", showBackground = true)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode"
)
@Composable
private fun PreviewPasswordOutlinedTextInput() {
    TimeManagmentProjectTheme {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)){

            PasswordOutlinedTextInput(
                text = "",
                name = "Password"
            ) {

            }
        }
    }
}