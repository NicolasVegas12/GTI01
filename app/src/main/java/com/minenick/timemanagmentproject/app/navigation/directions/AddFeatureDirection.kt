package com.minenick.timemanagmentproject.app.navigation.directions

import kotlinx.serialization.Serializable

sealed class AddFeatureDirection : Destination {

    @Serializable
    data object AddFeatureRoute : AddFeatureDirection()
}