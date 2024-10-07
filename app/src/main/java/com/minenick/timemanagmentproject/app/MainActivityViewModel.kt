package com.minenick.timemanagmentproject.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minenick.timemanagmentproject.app.navigation.components.NavigationAction
import com.minenick.timemanagmentproject.app.navigation.components.Navigator
import com.minenick.timemanagmentproject.app.navigation.directions.Destination
import com.minenick.timemanagmentproject.app.navigation.directions.HomeDirection
import com.minenick.timemanagmentproject.app.navigation.directions.RootGraph
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val navigator: Navigator) : ViewModel() {

    val navigationActions: Flow<NavigationAction> = navigator.navigationActions
    val startDestination = navigator.startDestination

    fun bottomBarNavigation(nextRoute: Destination) {
        viewModelScope.launch {
            navigator.navigate(destination = nextRoute,
                navOptions = {
                    popUpTo(RootGraph.HomeGraph) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                })
        }
    }
}