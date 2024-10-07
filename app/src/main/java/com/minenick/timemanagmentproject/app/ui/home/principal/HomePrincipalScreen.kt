package com.minenick.timemanagmentproject.app.ui.home.principal

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.minenick.timemanagmentproject.app.theme.TimeManagmentProjectTheme
import com.minenick.timemanagmentproject.app.ui.home.principal.components.HomePrincipalFeatureItem
import com.minenick.timemanagmentproject.app.ui.home.principal.components.HomePrincipalHeaderComponent

@Composable
fun HomePrincipalScreen(
    navToAdd: () -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            ,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        item {
            HomePrincipalHeaderComponent(workSpaceTitle = "My Workspace", navToAdd = navToAdd)
        }
        item { Spacer(modifier = Modifier) }
        items(4) {
            HomePrincipalFeatureItem(taskName = "Design Task")
        }

    }
}

@Preview(name = "LightMode")
@Preview(name = "NightMode", uiMode = Configuration.UI_MODE_NIGHT_YES)

@Composable
private fun PreviewHomePrincipalScreen() {
    TimeManagmentProjectTheme {
        Box(Modifier.background(MaterialTheme.colorScheme.background)) {
            HomePrincipalScreen({})
        }
    }
}