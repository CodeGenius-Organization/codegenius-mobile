package com.example.codegenius.feature.aluno.login.ui.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codegenius.feature.aluno.login.models.Register
import com.example.codegenius.feature.aluno.login.repositories.IRegisterRepository
import com.example.codegenius.feature.aluno.login.ui.states.RegisterScreenState
import com.example.codegenius.feature.aluno.login.ui.states.RegisterScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException

class RegisterScreenViewModel(
    private val repository: IRegisterRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<RegisterScreenUiState> = MutableStateFlow(
        RegisterScreenUiState()
    )

    val state = MutableLiveData<RegisterScreenState>(RegisterScreenState.Loading)
    val uiState get() = _uiState.asStateFlow()

    init {
        _uiState.update { currentState ->
            currentState.copy(
                onNameChange = {
                    _uiState.value = _uiState.value.copy(
                        name = it,
                    )
                },
                onLastNameChange = {
                    _uiState.value = _uiState.value.copy(
                        lastName = it,
                    )
                },
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
                onConfirmPasswordChange = {
                    _uiState.value = _uiState.value.copy(
                        confirmPassword = it,
                    )
                },
            )
        }
    }

    fun visibilityChange() {
        _uiState.update { currentState ->
            currentState.copy(
                visibilityPassword = !currentState.visibilityPassword
            )
        }
    }

    fun visibilityConfirmPassChange() {
        _uiState.update { currentState ->
            currentState.copy(
                visibilityConfirmPass = !currentState.visibilityConfirmPass
            )
        }
    }

    fun postRegister() {
        val register = Register(
            nome = (_uiState.value.name+" "+_uiState.value.lastName),
            email = _uiState.value.email,
            password = _uiState.value.password
        )
        Log.d("### Cria", "${register}")
        viewModelScope.launch {
            try {
                state.value = RegisterScreenState.Loading
                val response = repository.postRegister(register)
                Log.d("### Response", "${response}")
                if (response.isSuccessful) {
                    state.value = RegisterScreenState.Success(data = response)
                    Log.d("###API", "Cadastrado com sucesso")
                } else {
                    throw Exception("Erro desconhecido")
                }
            }  catch (e: HttpException) {
                val message = when (e.code()) {
                    400 -> "Login Inválido"
                    404 -> "Email ou senha incorretos"
                    409 -> "Email já cadastrado"
                    else -> "Erro desconhecido"
                }
                state.value = RegisterScreenState.Error(message)
            } catch (e: Exception) {
                state.value = RegisterScreenState.Error(
                    e.message ?: "Erro desconhecido"
                )
            }
        }
    }

}