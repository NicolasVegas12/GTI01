package com.minenick.timemanagmentproject.app.ui.splash

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.minenick.timemanagmentproject.app.navigation.directions.RootGraph
import com.minenick.timemanagmentproject.app.navigation.directions.SplashDirection

fun NavGraphBuilder.splashGraph() {
    navigation<RootGraph.SplashGraph>(
        startDestination = SplashDirection.SplashScreen
    ) {
        composable<SplashDirection.SplashScreen> {
            val viewModel = hiltViewModel<SplashViewModel>()
            val splashRedirectScreenState by viewModel.splashRedirectScreenState.collectAsStateWithLifecycle()
            SplashScreen()
        }

    }
}