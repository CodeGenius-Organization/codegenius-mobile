package com.example.codegenius.feature.aluno.login.ui.states

data class LoginScreenUiState (
    val email: String = "",
    val password: String = "",
    val onEmailChange: (String) -> Unit = {},
    val onPasswordChange: (String) -> Unit = {},
    var visibility: Boolean = false,
)