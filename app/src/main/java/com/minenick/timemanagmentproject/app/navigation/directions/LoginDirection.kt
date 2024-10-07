package com.minenick.timemanagmentproject.app.navigation.directions

import kotlinx.serialization.Serializable

sealed class LoginDirection : Destination {
    @Serializable
    data object LoginScreen : LoginDirection()
}