package com.minenick.timemanagmentproject.app.ui.home.notifications

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeNotificationsScreen(
    modifier: Modifier = Modifier,
) {
    Box(modifier) {
        Text(text = "HomeNotificationsScreen")
    }
}

@Preview(name = "HomeNotificationsScreen")
@Composable
private fun PreviewHomeNotificationsScreen() {
    HomeNotificationsScreen()
}