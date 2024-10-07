package com.minenick.timemanagmentproject.app.ui.home.principal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minenick.timemanagmentproject.app.navigation.components.Navigator
import com.minenick.timemanagmentproject.app.navigation.directions.HomeDirection
import com.minenick.timemanagmentproject.app.navigation.directions.RootGraph
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomePrincipalViewModel @Inject constructor(
    private val navigator: Navigator
): ViewModel() {

    fun navigateToAddFeature() {
        viewModelScope.launch {
            navigator.navigate(
                destination = RootGraph.AddFeatureGraph,
            )
        }
    }
}