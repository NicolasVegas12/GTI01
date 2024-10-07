package com.minenick.timemanagmentproject.app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.minenick.timemanagmentproject.app.components.bottomNavBar.BottomNavigationBar
import com.minenick.timemanagmentproject.app.theme.TimeManagmentProjectTheme
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            TimeManagmentProjectTheme {
                val navControllerEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navControllerEntry?.destination
                val viewModel = hiltViewModel<MainActivityViewModel>()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {

                        BottomNavigationBar(
                            route = currentDestination?.route,
                            navigate = viewModel::bottomBarNavigation
                        )
                    }
                ) {
                    Box(modifier = Modifier.safeDrawingPadding()) {
                        RootNavGraph(
                            navController = navController,
                            viewModel = viewModel
                        )
                    }
                }
            }
        }
    }
}
