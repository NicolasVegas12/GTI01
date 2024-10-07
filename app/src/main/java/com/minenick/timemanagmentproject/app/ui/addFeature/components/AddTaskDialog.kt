package com.minenick.timemanagmentproject.app.ui.addFeature.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.minenick.timemanagmentproject.app.components.button.TimeManagementButton
import com.minenick.timemanagmentproject.app.components.inputs.OutlinedSelectionTextInput
import com.minenick.timemanagmentproject.app.components.inputs.TextInput
import com.minenick.timemanagmentproject.app.theme.TimeManagmentProjectTheme

@Composable
fun AddTaskDialog(onDismiss: () -> Unit, onAccept: () -> Unit) {
    Box(
        Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                TextInput(text = "", title = "Issue Summary", modifier = Modifier.weight(1f)) {

                }

                TimeManagementButton(text = "Create", modifier = Modifier.weight(0.3f)) {
                    onAccept.invoke()
                    onDismiss.invoke()
                }

            }
            TextInput(
                text = "", title = "Description", modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            ) {

            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {

                OutlinedSelectionTextInput(
                    name = "Sprint",
                    text = "",
                    icon = Icons.Rounded.KeyboardArrowDown,
                    modifier = Modifier.weight(1f)
                ) {

                }
                OutlinedSelectionTextInput(
                    name = "Priority",
                    text = "",
                    icon = Icons.Rounded.KeyboardArrowDown,
                    modifier = Modifier.weight(1f)
                ) {

                }
            }
            OutlinedSelectionTextInput(
                name = "Type",
                text = "",
                icon = Icons.Rounded.KeyboardArrowDown
            ) {

            }
        }
    }
}

@Preview(name = "LightMode")
@Preview(name = "NightMode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewAddTaskDialog() {
    TimeManagmentProjectTheme {
        Box(Modifier.background(MaterialTheme.colorScheme.onBackground)) {

            AddTaskDialog(onDismiss = {}, onAccept = {})
        }
    }
}