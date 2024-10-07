package com.minenick.timemanagmentproject.app.navigation.components

import androidx.navigation.NavOptionsBuilder
import com.minenick.timemanagmentproject.app.navigation.directions.Destination

sealed interface NavigationAction {

    data class Navigate(
        val destination: Destination,
        val navOptions: NavOptionsBuilder.() -> Unit = {}
    ): NavigationAction

    data object NavigateUp: NavigationAction
}