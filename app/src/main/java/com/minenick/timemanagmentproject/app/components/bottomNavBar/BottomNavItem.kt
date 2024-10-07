package com.minenick.timemanagmentproject.app.components.bottomNavBar

import androidx.compose.ui.graphics.vector.ImageVector
import com.minenick.timemanagmentproject.app.navigation.directions.Destination

data class BottomNavItem(
    val name: String,
    val route: Destination,
    val icon: ImageVector,
)
