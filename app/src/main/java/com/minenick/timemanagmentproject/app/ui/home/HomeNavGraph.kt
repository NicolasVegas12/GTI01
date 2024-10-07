package com.minenick.timemanagmentproject.app.ui.home

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.minenick.timemanagmentproject.app.navigation.directions.HomeDirection
import com.minenick.timemanagmentproject.app.navigation.directions.RootGraph
import com.minenick.timemanagmentproject.app.ui.home.notifications.HomeNotificationsScreen
import com.minenick.timemanagmentproject.app.ui.home.principal.HomePrincipalScreen
import com.minenick.timemanagmentproject.app.ui.home.principal.HomePrincipalViewModel
import com.minenick.timemanagmentproject.app.ui.home.profile.HomeProfileScreen
import com.minenick.timemanagmentproject.app.ui.home.tasks.HomeTasksScreen

fun NavGraphBuilder.homeGraph() {

    navigation<RootGraph.HomeGraph>(
        startDestination = HomeDirection.HomePrincipalRoute
    ) {
        composable<HomeDirection.HomePrincipalRoute> {
            val viewModel = hiltViewModel<HomePrincipalViewModel>()
            HomePrincipalScreen(
                navToAdd = viewModel::navigateToAddFeature
            )
        }

        composable<HomeDirection.HomeTaskRoute> {
            HomeTasksScreen()
        }

        composable<HomeDirection.HomeProfileRoute> {
            HomeProfileScreen()


        }

        composable<HomeDirection.HomeNotificationsRoute> {
            HomeNotificationsScreen()

        }

        /*composable<HomeDirection.HomeDetailScreen> {
            val viewModel = koinViewModel<HomeDetailViewModel>()
            val args = it.toRoute<HomeDirection.HomeDetailScreen>()
            HomeDetailScreen(id = args.id, goBack = viewModel::goBack)
        }*/
    }
}