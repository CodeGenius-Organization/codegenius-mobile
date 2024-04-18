package com.example.codegenius.feature.aluno.login.views.states

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.example.codegenius.feature.aluno.course.view.CourseActivity

data class LoginScreenUiState (
    val email: String = "",
    val password: String = "",
    val onEmailChange: (String) -> Unit = {},
    val onPasswordChange: (String) -> Unit = {}
)