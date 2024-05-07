package com.example.codegenius.feature.aluno.login.ui.states

import com.example.codegenius.feature.aluno.login.models.Token
import retrofit2.Response

sealed interface RegisterScreenState {

        data object Loading: RegisterScreenState

        data class Success (
            val data: Response<Void>
        ) : RegisterScreenState

        data class Error(
            val message: String
        ) : RegisterScreenState
}