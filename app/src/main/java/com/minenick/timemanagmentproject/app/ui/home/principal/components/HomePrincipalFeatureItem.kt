package com.minenick.timemanagmentproject.app.ui.home.principal.components

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.minenick.timemanagmentproject.app.theme.TimeManagmentProjectTheme

@Composable
fun HomePrincipalFeatureItem(
    taskName: String,
) {
    var expanded by remember {
        mutableStateOf(false    )
    }
    Box(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.onBackground)
            .clickable { expanded = !expanded }

    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(8.dp),
        ) {

            Row(

                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary)
                        .size(10.dp)
                )
                Text(
                    text = taskName,
                    color = MaterialTheme.colorScheme.background,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.weight(1f)
                )
                if(expanded ){
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowUp,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.background
                    )
                }else{

                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.background
                    )
                }
            }
            AnimatedVisibility(expanded) {
                Column (verticalArrangement = Arrangement.spacedBy(8.dp),){

                    List(2){
                        HomePrincipalTaskItem("Bug Found during the login flow, The user signs in with social account")
                    }
                }
            }
        }

    }
}

@Preview(name = "LightMode")
@Preview(name = "NightMode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewHomePrincipalHiddenFeatureItem() {
    TimeManagmentProjectTheme {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {

            HomePrincipalFeatureItem("Design Task")
        }
    }
}