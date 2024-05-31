package com.example.codegenius.feature.aluno.login.ui.viewmodels

import android.util.Log
import androidx.compose.material3.SnackbarDuration
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

    private val state = MutableLiveData<RegisterScreenState>(RegisterScreenState.Loading)
    val uiState get() = _uiState.asStateFlow()

    init {
        _uiState.update { currentState ->
            currentState.copy(
                onNameChange = {
                    _uiState.value = _uiState.value.copy(
                        name = it,
                        nameError = validateName(it)
                    )
                },
                onLastNameChange = {
                    _uiState.value = _uiState.value.copy(
                        lastName = it,
                        lastNameError = validateName(it)
                    )
                },
                onEmailChange = {
                    _uiState.value = _uiState.value.copy(
                        email = it,
                        emailError = validateEmail(it)
                    )
                },
                onPasswordChange = {
                    _uiState.value = _uiState.value.copy(
                        password = it,
                        passError = validatePassword(it)
                    )
                },
                onConfirmPasswordChange = {
                    _uiState.value = _uiState.value.copy(
                        confirmPassword = it,
                        confirmPassError = validatePassword(it)
                    )
                },
                onCheck = {
                    _uiState.value = _uiState.value.copy(
                        checked = it
                    )
                },
                onShowDialog = {
                    _uiState.value = _uiState.value.copy(
                        showDialog = it
                    )
                }
            )
        }
    }

    private fun validateName(name: String): Boolean {
        val reg = Regex("^[A-Za-zÀ-ÖØ-öø-ÿ'-]{2,}$")
        return name.isNotBlank() && !reg.matches(name)
    }

    private fun validateEmail(email: String): Boolean {
        val reg = Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
        return email.isNotBlank() && !reg.matches(email)
    }

    private fun validatePassword(password: String): Boolean {
        val reg = Regex("^(?=.*[A-Z])(?=.*[0-9])(?=.*[^A-Za-z0-9]).{8,}$")
        return password.isNotBlank() && !reg.matches(password)
    }

    private fun cleanTextFields() {
        _uiState.update { currentState ->
            currentState.copy(
                name = "",
                lastName = "",
                email = "",
                password = "",
                confirmPassword = "",
                nameError = false,
                lastNameError = false,
                emailError = false,
                passError = false,
                confirmPassError = false,
                checked = false
            )
        }
    }

    private fun cleanPassword() {
        _uiState.update { currentState ->
            currentState.copy(
                password = "",
                confirmPassword = "",
                passError = true,
                confirmPassError = true,
            )
        }
    }
    private suspend fun showSnackbar(message: String) {
        _uiState.value.snackbarHostState.showSnackbar(
            message = message,
            withDismissAction = true,
            duration = SnackbarDuration.Short
        )
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

    fun postRegister(onNavigateRegister: () -> Unit) {
        viewModelScope.launch {
            if (_uiState.value.nameError || _uiState.value.lastNameError || _uiState.value.emailError || _uiState.value.passError || _uiState.value.confirmPassError) {
                showSnackbar("Verifique se todos os campos foram preenchidos corretamente!")
            } else if (!_uiState.value.password.equals(_uiState.value.confirmPassword)) {
                showSnackbar("Senhas não coincidem!")
                cleanPassword()
            } else {
                val register = Register(
                    nome = (_uiState.value.name + " " + _uiState.value.lastName),
                    email = _uiState.value.email,
                    password = _uiState.value.password
                )
                try {
                    state.value = RegisterScreenState.Loading
                    val response = repository.postRegister(register)
                    if (response.isSuccessful) {
                        state.value = RegisterScreenState.Success(data = response)
                        cleanTextFields()
                        onNavigateRegister()
                    } else {
                        throw Exception("Erro desconhecido")
                    }
                } catch (e: HttpException) {
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
}