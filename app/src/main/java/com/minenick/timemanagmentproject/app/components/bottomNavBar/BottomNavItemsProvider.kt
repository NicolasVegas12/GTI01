package com.minenick.timemanagmentproject.app.components.bottomNavBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Task
import com.minenick.timemanagmentproject.app.navigation.directions.HomeDirection

object BottomNavItemsProvider {
    val BOTTOM_NAV_ITEMS = listOf(
        BottomNavItem(
            name = "Explorar",
            icon = Icons.Outlined.Explore,
            route = HomeDirection.HomePrincipalRoute,
        ),
        BottomNavItem(
            name = "Tareas",
            icon = Icons.Outlined.Task,
            route = HomeDirection.HomeTaskRoute,
        ),
        BottomNavItem(
            name = "Notificaciones",
            icon = Icons.Outlined.Notifications,
            route = HomeDirection.HomeNotificationsRoute,
        ),
        BottomNavItem(
            name = "Perfil",
            icon = Icons.Outlined.Person,
            route = HomeDirection.HomeProfileRoute,
        ),
    )
}