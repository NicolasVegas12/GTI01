package com.minenick.timemanagmentproject.app.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minenick.timemanagmentproject.app.components.states.GenericScreenState
import com.minenick.timemanagmentproject.app.navigation.components.Navigator
import com.minenick.timemanagmentproject.app.navigation.directions.RootGraph
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

typealias SplashRedirectState = GenericScreenState<Boolean>

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val navigator: Navigator,
) : ViewModel() {

    private val _splashRedirectScreenState = MutableStateFlow(SplashRedirectState())
    val splashRedirectScreenState = _splashRedirectScreenState.onStart { loadData() }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000L),
        SplashRedirectState()
    )


    private fun loadData() = viewModelScope.launch {
        _splashRedirectScreenState.value = SplashRedirectState(isLoading = true)
        try {

            delay(3000)

            navigateToAuth()


        } catch (e: Exception) {
            _splashRedirectScreenState.value = SplashRedirectState(error = e.message.toString())

        }

    }

    private suspend fun navigateToAuth() {
        navigator.navigate(RootGraph.AuthGraph, navOptions = {
            popUpTo(navigator.startDestination) {
                inclusive = false
            }
        })
    }


}