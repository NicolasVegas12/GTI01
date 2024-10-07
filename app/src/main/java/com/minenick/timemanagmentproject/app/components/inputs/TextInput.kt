package com.minenick.timemanagmentproject.app.components.inputs

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.minenick.timemanagmentproject.app.theme.TimeManagmentProjectTheme

@Composable
fun TextInput(
    text: String,
    title: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    enabled:Boolean = true,
    singleLine:Boolean = false,
    leadingIcon:(@Composable ()->Unit)?  = null,
    onTextChange: (String) -> Unit
) {
    TextField(
        value = text,
        enabled = enabled,
        onValueChange = onTextChange,
        modifier = modifier.fillMaxWidth(),
        label = {
            Text(
                text = title,
                style = if (text.isEmpty()) MaterialTheme.typography.labelMedium else MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f)
            )

        },
        singleLine = singleLine,
        textStyle = MaterialTheme.typography.labelMedium ,
        leadingIcon = leadingIcon,
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.colors(
            focusedTextColor = MaterialTheme.colorScheme.onBackground,
            unfocusedTextColor = MaterialTheme.colorScheme.onBackground,
            unfocusedContainerColor = backgroundColor,
            focusedContainerColor = backgroundColor,
            disabledContainerColor = backgroundColor,
            disabledTextColor = MaterialTheme.colorScheme.onBackground,
            focusedIndicatorColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f),
            unfocusedIndicatorColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f)
        )

    )
}

@Preview(name = "LightMode")
@Preview(name = "NightMode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewTextInput() {
    TimeManagmentProjectTheme {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)){
            TextInput(text = "Nicolas", title = "Nombre de Invitado") {

            }
        }
    }
}