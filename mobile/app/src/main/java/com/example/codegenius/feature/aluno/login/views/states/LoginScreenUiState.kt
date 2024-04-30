package com.example.codegenius.feature.aluno.login.views.states

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.ui.graphics.vector.ImageVector

data class LoginScreenUiState (
    val email: String = "",
    val password: String = "",
    val onEmailChange: (String) -> Unit = {},
    val onPasswordChange: (String) -> Unit = {},
    var visibility: Boolean = false,
)