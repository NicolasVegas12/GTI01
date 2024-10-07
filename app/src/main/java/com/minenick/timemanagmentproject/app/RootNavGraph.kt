package com.minenick.timemanagmentproject.app

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.minenick.timemanagmentproject.app.navigation.components.NavigationAction
import com.minenick.timemanagmentproject.app.navigation.components.ObserveAsEvents
import com.minenick.timemanagmentproject.app.ui.addFeature.addFeatureGraph
import com.minenick.timemanagmentproject.app.ui.home.homeGraph
import com.minenick.timemanagmentproject.app.ui.login.loginGraph
import com.minenick.timemanagmentproject.app.ui.splash.splashGraph

@Composable
fun RootNavGraph(navController: NavHostController, viewModel: MainActivityViewModel) {


    ObserveAsEvents(flow = viewModel.navigationActions) { action ->
        when (action) {
            is NavigationAction.Navigate -> navController.navigate(
                action.destination
            ) {
                action.navOptions(this)
            }

            NavigationAction.NavigateUp -> navController.navigateUp()
        }
    }
    NavHost(
        navController = navController,
        startDestination = viewModel.startDestination,
    ) {
        homeGraph()
        loginGraph()
        splashGraph()
        addFeatureGraph()

    }
}