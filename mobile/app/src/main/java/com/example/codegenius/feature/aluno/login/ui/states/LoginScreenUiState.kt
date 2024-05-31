package com.example.codegenius.feature.aluno.login.ui.states

import androidx.compose.material3.SnackbarHostState

data class LoginScreenUiState (
    val email: String = "",
    val password: String = "",
    var emailError: Boolean = false,
    val passwordError: Boolean = false,
    val onEmailChange: (String) -> Unit = {},
    val onPasswordChange: (String) -> Unit = {},
    val snackbarHostState: SnackbarHostState = SnackbarHostState(),
    var visibility: Boolean = false,
)