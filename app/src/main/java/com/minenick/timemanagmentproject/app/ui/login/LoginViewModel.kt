package com.minenick.timemanagmentproject.app.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minenick.timemanagmentproject.app.navigation.components.Navigator
import com.minenick.timemanagmentproject.app.navigation.directions.RootGraph
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val navigator: Navigator,
) : ViewModel() {

    fun login() {
        viewModelScope.launch {
            navigator.navigate(
                destination = RootGraph.HomeGraph,
                navOptions = {
                    popUpTo(RootGraph.AuthGraph) {
                        inclusive = true
                    }
                }
            )
        }
    }
}