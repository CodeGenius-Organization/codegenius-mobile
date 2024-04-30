package com.example.codegenius.feature.aluno.login.viewmodels

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.ui.graphics.vector.ImageVector
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
                },
            )
        }
    }


    fun visibilityChange(){
        _uiState.update {currentState ->
            currentState.copy(
                visibility = !currentState.visibility
            )
        }
    }
}