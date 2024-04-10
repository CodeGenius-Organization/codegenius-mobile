package com.example.codegenius.feature.aluno.navigation;

sealed class AppDestination(val route: String) {
    object Login: AppDestination("login")
    object Register: AppDestination("register")
    object Loading: AppDestination("loading")
}
