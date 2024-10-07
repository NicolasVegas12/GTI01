package com.minenick.timemanagmentproject.app.components.states

data class GenericScreenState<T>(
    var isLoading: Boolean = false,
    var response: T? = null,
    val error: String = "",
    val code:Int = 0
)
