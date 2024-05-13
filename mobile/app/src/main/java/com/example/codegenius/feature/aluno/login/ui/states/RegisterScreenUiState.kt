package com.example.codegenius.feature.aluno.login.ui.states

data class RegisterScreenUiState (
    val name: String = "",
    val lastName: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val onNameChange: (String) -> Unit = {},
    val onLastNameChange: (String) -> Unit = {},
    val onEmailChange: (String) -> Unit = {},
    val onPasswordChange: (String) -> Unit = {},
    val onConfirmPasswordChange: (String) -> Unit = {},
    val visibilityPassword: Boolean = false,
    val visibilityConfirmPass: Boolean = false,
)