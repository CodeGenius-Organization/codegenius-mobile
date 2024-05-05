package com.example.codegenius.feature.aluno.login.ui.states

import com.example.codegenius.feature.aluno.login.models.Token

sealed interface LoginScreenState {
        data object Loading: LoginScreenState

        data class Success (
            val data: Token
        ) : LoginScreenState

        data class Error(
            val message: String
        ) : LoginScreenState

}