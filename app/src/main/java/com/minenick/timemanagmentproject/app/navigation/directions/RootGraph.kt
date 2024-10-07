package com.minenick.timemanagmentproject.app.navigation.directions

import kotlinx.serialization.Serializable

sealed class RootGraph : Destination {
    @Serializable
    data object AuthGraph : RootGraph()

    @Serializable
    data object HomeGraph : RootGraph()

    @Serializable
    data object SplashGraph : RootGraph()

    @Serializable
    data object AddFeatureGraph:RootGraph()
}