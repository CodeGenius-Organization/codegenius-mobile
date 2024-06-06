package com.example.codegenius.feature.aluno.login.ui.viewmodels

import android.util.Log
import androidx.compose.material3.SnackbarDuration
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codegenius.feature.aluno.login.models.Login
import com.example.codegenius.feature.aluno.login.repositories.ILoginRepository
import com.example.codegenius.feature.aluno.login.ui.states.LoginScreenState
import com.example.codegenius.feature.aluno.login.ui.states.LoginScreenUiState
import com.example.codegenius.feature.aluno.shared.util.singleton.Util
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
                        emailError = validateEmail(it)
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

    fun validateEmail(email: String): Boolean {
        val reg = Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
        if (email.isNotBlank() && !reg.matches(email)) {
            return true
        }
        return false
    }


    fun cleanTextFields(isError: Boolean) {
        _uiState.update { currentState ->
            currentState.copy(
                email = "",
                password = "",
                emailError = isError,
                passwordError = isError
            )
        }
    }

    fun postLogin(onNavigateCourse: () -> Unit) {
        viewModelScope.launch {
            if (uiState.value.emailError || uiState.value.passwordError) {
                cleanTextFields(true)
                uiState.value.snackbarHostState.showSnackbar(
                    message = "Credenciais inválidas!",
                    withDismissAction = true,
                    duration = SnackbarDuration.Short
                )
            } else {
                val login = Login(_uiState.value.email, _uiState.value.password)
                try {
                    state.value = LoginScreenState.Loading
                    val response = repository.postLogin(login)
                    if (response.isSuccessful) {
                        response.body()?.let { token ->
                            state.value = LoginScreenState.Success(data = token)
                            Util.getInstance().authToken = token
                            Util.getInstance().email = _uiState.value.email
                            cleanTextFields(false)
                            onNavigateCourse()
                        }
                            ?: throw Exception("O corpo da resposta está nulo/não veio o token")
                    } else {
                        throw Exception("Erro desconhecido")
                    }
                } catch (e: HttpException) {
                    cleanTextFields(true)
                    uiState.value.snackbarHostState.showSnackbar(
                        message = "Credenciais inválidas!",
                        withDismissAction = true,
                        duration = SnackbarDuration.Short
                    )
                    val message = when (e.code()) {
                        400 -> "Login Inválido"
                        404 -> "Email ou senha incorretos"
                        502 -> "Timeout"
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
    }

    fun visibilityChange() {
        _uiState.update { currentState ->
            currentState.copy(
                visibility = !currentState.visibility
            )
        }
    }
}