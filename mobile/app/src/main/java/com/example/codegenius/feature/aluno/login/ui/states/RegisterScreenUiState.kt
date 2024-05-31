package com.example.codegenius.feature.aluno.login.ui.states

import androidx.compose.material3.SnackbarHostState

data class RegisterScreenUiState (
    val name: String = "",
    val nameError: Boolean = false,
    val lastName: String = "",
    val lastNameError: Boolean = false,
    val email: String = "",
    val emailError: Boolean = false,
    val password: String = "",
    val passError: Boolean = false,
    val confirmPassword: String = "",
    val confirmPassError: Boolean = false,
    val onNameChange: (String) -> Unit = {},
    val onLastNameChange: (String) -> Unit = {},
    val onEmailChange: (String) -> Unit = {},
    val onPasswordChange: (String) -> Unit = {},
    val onConfirmPasswordChange: (String) -> Unit = {},
    val visibilityPassword: Boolean = false,
    val visibilityConfirmPass: Boolean = false,
    val checked: Boolean = false,
    val onCheck: (Boolean) -> Unit = {},
    val snackbarHostState: SnackbarHostState = SnackbarHostState(),
    val showDialog: Boolean = false,
    val onShowDialog: (Boolean) -> Unit = {},
)