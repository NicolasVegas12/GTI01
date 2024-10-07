package com.minenick.timemanagmentproject.app.ui.home.tasks

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeTasksScreen(
    modifier: Modifier = Modifier,
) {
    Box(modifier) {
        Text(text = "HomeTasksScreen")
    }
}

@Preview(name = "HomeTasksScreen")
@Composable
private fun PreviewHomeTasksScreen() {
    HomeTasksScreen()
}