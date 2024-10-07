package com.minenick.timemanagmentproject.app.di

import com.minenick.timemanagmentproject.app.navigation.components.DefaultNavigator
import com.minenick.timemanagmentproject.app.navigation.components.Navigator
import com.minenick.timemanagmentproject.app.navigation.directions.RootGraph
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigatorProvider {

    @Provides
    @Singleton
    fun navigatorProvider(): Navigator = DefaultNavigator(startDestination = RootGraph.SplashGraph)
}