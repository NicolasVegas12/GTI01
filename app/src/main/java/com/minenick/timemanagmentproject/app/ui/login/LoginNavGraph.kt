package com.minenick.timemanagmentproject.app.ui.login

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.minenick.timemanagmentproject.app.navigation.directions.LoginDirection
import com.minenick.timemanagmentproject.app.navigation.directions.RootGraph

fun NavGraphBuilder.loginGraph() {
    navigation<RootGraph.AuthGraph>(
        startDestination = LoginDirection.LoginScreen
    ) {
        composable<LoginDirection.LoginScreen> {
            val viewModel = hiltViewModel<LoginViewModel>()
            LoginScreen(viewModel::login)
        }
    }
}