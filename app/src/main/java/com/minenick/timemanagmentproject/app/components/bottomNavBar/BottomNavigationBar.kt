package com.minenick.timemanagmentproject.app.components.bottomNavBar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.minenick.timemanagmentproject.app.components.bottomNavBar.BottomNavItemsProvider.BOTTOM_NAV_ITEMS
import com.minenick.timemanagmentproject.app.navigation.directions.Destination
import com.minenick.timemanagmentproject.app.navigation.directions.HomeDirection
import com.minenick.timemanagmentproject.app.theme.TimeManagmentProjectTheme

@Composable
fun BottomNavigationBar(
    route: String?,
    navigate: (Destination) -> Unit,
) {
    AnimatedVisibility(BOTTOM_NAV_ITEMS.any { it.route::class.qualifiedName == route }) {

        BottomNavigation(
            backgroundColor = MaterialTheme.colorScheme.primaryContainer,
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 40.dp)
                .clip(RoundedCornerShape(20.dp))
                .height(50.dp)
        ) {
            BOTTOM_NAV_ITEMS.map { item ->
                AddItem(
                    screen = item,
                    selected = (item.route::class.qualifiedName == route),
                    onClick = { next ->

                        navigate.invoke(next)

                    }
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomNavItem,
    selected: Boolean,
    onClick: (Destination) -> Unit,
) {

    BottomNavigationItem(
        selected = selected,
        onClick = {
            onClick.invoke(screen.route)
        },
        icon = {
            val color = if (selected) MaterialTheme.colorScheme.onBackground else Color.Gray
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,

            ) {
                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    imageVector = screen.icon,
                    contentDescription = screen.name,
                    tint = color
                )
                Spacer(modifier = Modifier.weight(1f))
                if(selected){
                    Divider(
                        modifier = Modifier.fillMaxWidth(0.5f),
                        color = color,
                        thickness = 2.dp
                    )
                }
            }
        }
    )

}

@Preview(name = "BottomNavigationBar")
@Composable
private fun PreviewBottomNavigationBar() {
    TimeManagmentProjectTheme {
        BottomNavigationBar(HomeDirection.HomePrincipalRoute::class.qualifiedName) { }
    }
}