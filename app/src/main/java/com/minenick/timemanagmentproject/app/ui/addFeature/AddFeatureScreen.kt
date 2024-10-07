package com.minenick.timemanagmentproject.app.ui.addFeature

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.minenick.timemanagmentproject.app.components.button.TimeManagementButton
import com.minenick.timemanagmentproject.app.components.inputs.OutlinedTextInput
import com.minenick.timemanagmentproject.app.theme.TimeManagmentProjectTheme
import com.minenick.timemanagmentproject.app.ui.addFeature.components.AddTaskDialog
import com.minenick.timemanagmentproject.app.ui.home.principal.components.HomePrincipalTaskItem

@Composable
fun AddFeatureScreen(
) {
    var addTaskVisibility by remember {
        mutableStateOf(false)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = "New Feature",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleLarge
                )
            }
            item {
                OutlinedTextInput(name = "Title", text = "", onTextFieldChanged = {

                })
            }
            item {
                OutlinedTextInput(
                    name = "Description",
                    modifier = Modifier.height(120.dp),
                    text = "",
                    singleLine = false,
                    onTextFieldChanged = {

                    })
            }
            item {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Text(
                        text = "Tasks",
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.clickable {
                            addTaskVisibility = true
                        }
                    )
                }
            }

            items(4){
                HomePrincipalTaskItem(comment = "Test New Prototype")
            }
        }
        TimeManagementButton(modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(24.dp), text = "Save") {}
    }
    AnimatedVisibility(visible = addTaskVisibility) {

        Dialog(onDismissRequest = { addTaskVisibility = false}) {
            AddTaskDialog(onDismiss = {addTaskVisibility= false}, onAccept = {})
        }

    }
}

@Preview(name = "LightMode")
@Preview(name = "NightMode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewAddFeatureScreen() {
    TimeManagmentProjectTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {

            AddFeatureScreen()
        }
    }
}