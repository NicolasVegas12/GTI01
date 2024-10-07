package com.minenick.timemanagmentproject.app.navigation.directions

import kotlinx.serialization.Serializable

sealed class HomeDirection : Destination {

    @Serializable
    data object HomePrincipalRoute : HomeDirection()

    @Serializable
    data object HomeTaskRoute : HomeDirection()

    @Serializable
    data object HomeProfileRoute : HomeDirection()

    @Serializable
    data object HomeNotificationsRoute : HomeDirection()

}