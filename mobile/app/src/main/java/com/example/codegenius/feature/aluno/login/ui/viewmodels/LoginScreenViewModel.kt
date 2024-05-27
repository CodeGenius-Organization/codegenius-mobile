package com.example.codegenius.feature.aluno.login.ui.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codegenius.feature.aluno.login.models.Login
import com.example.codegenius.feature.aluno.login.repositories.ILoginRepository
import com.example.codegenius.feature.aluno.login.ui.states.LoginScreenState
import com.example.codegenius.feature.aluno.login.ui.states.LoginScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException

class LoginScreenViewModel(
    private val repository: ILoginRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<LoginScreenUiState> = MutableStateFlow(
        LoginScreenUiState()
    )

    private val state = MutableLiveData<LoginScreenState>(LoginScreenState.Loading)
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

    fun postLogin(onNavigateCourse: () -> Unit) {
        val login = Login(_uiState.value.email, _uiState.value.password)
        viewModelScope.launch {
            try {
                state.value = LoginScreenState.Loading
                val response = repository.postLogin(login)
                if (response.isSuccessful) {
                    response.body()?.let { token ->
                        state.value = LoginScreenState.Success(data = token)
                        Log.d("###Token", "${token}")
                        onNavigateCourse()
                    }
                        ?: throw Exception("O corpo da resposta está nulo")
                } else {
                    throw Exception("Erro desconhecido")
                }
            }  catch (e: HttpException) {
                val message = when (e.code()) {
                    400 -> "Login Inválido"
                    404 -> "Email ou senha incorretos"
                    else -> "Erro desconhecido"
                }
                state.value = LoginScreenState.Error(message)
            } catch (e: Exception) {
                state.value = LoginScreenState.Error(
                    e.message ?: "Erro desconhecido"
                )
            }
        }
    }

    fun visibilityChange() {
        _uiState.update { currentState ->
            currentState.copy(
                visibility = !currentState.visibility
            )
        }
    }
}