package com.minenick.timemanagmentproject.app.navigation.directions

import kotlinx.serialization.Serializable

sealed class SplashDirection:Destination {
    @Serializable
    data object SplashScreen : SplashDirection()

}