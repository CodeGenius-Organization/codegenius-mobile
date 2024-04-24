package com.example.codegenius.feature.aluno.login.viewmodels

import androidx.lifecycle.ViewModel
import com.example.codegenius.feature.aluno.login.views.states.LoginScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginScreenViewModel : ViewModel() {

    private val _uiState: MutableStateFlow<LoginScreenUiState> = MutableStateFlow(
        LoginScreenUiState()
    )
    val uiState get() = _uiState.asStateFlow()
    init {
        _uiState.update { currentState ->
            currentState.copy(
                onEmailChange = {
                    _uiState.value = _uiState.value.copy(
                        email = it,
                    )
                },
                onPasswordChange = {
                    _uiState.value = _uiState.value.copy(
                        password = it,
                    )
                }
            )
        }
    }
}