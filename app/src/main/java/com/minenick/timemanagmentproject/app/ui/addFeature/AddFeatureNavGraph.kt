package com.minenick.timemanagmentproject.app.ui.addFeature

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.minenick.timemanagmentproject.app.navigation.directions.AddFeatureDirection
import com.minenick.timemanagmentproject.app.navigation.directions.RootGraph

fun NavGraphBuilder.addFeatureGraph() {
    navigation<RootGraph.AddFeatureGraph>(
        startDestination = AddFeatureDirection.AddFeatureRoute
    ) {
        composable<AddFeatureDirection.AddFeatureRoute> {
            AddFeatureScreen()
        }
    }
}