package com.example.codegenius.feature.aluno.login.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codegenius.R
import com.example.codegenius.feature.aluno.login.ui.components.CorporateInsignia
import com.example.codegenius.feature.aluno.login.ui.states.LoginScreenUiState
import com.example.codegenius.feature.aluno.login.ui.viewmodels.LoginScreenViewModel
import com.example.codegenius.feature.aluno.shared.ui.theme.BackgroundGenius
import com.example.codegenius.feature.aluno.shared.ui.theme.PlaceholderGenius

@Composable
fun LoginScreen(
    viewModel: LoginScreenViewModel,
    onNavigateToRegister: () -> Unit = {},
    onNavigateToCourse: () -> Unit = {}
) {

    val uiState by viewModel.uiState.collectAsState()
    LoginScreen(
        uiState = uiState,
        visibilityChange = { viewModel.visibilityChange() },
        onNavigateToRegister = onNavigateToRegister,
        onLogin = { viewModel.postLogin(onNavigateToCourse) }
    )
}

@Composable
fun LoginScreen(
    uiState: LoginScreenUiState = LoginScreenUiState(),
    visibilityChange: () -> Unit,
    onNavigateToRegister: () -> Unit = {},
    onLogin: () -> Unit
) {
    val email = uiState.email
    val emailError = uiState.emailError
    val password = uiState.password
    val passwordError = uiState.passwordError
    val visibility = uiState.visibility
    val snackbarHostState = uiState.snackbarHostState

    Scaffold(
        Modifier
            .fillMaxSize(),
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundGenius)
                .padding(it),
            verticalArrangement = Arrangement.Center
        ) {
            CorporateInsignia(Modifier.padding(bottom = 30.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 32.dp),
                    text = stringResource(R.string.login_label_welcome),
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp)
                        .background(
                            Color.Transparent
                        ),
                    maxLines = 1,
                    isError = emailError,
                    label = {
                        Text(
                            text = stringResource(R.string.login_label_email),
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.White,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Normal
                        )
                    },
                    value = email,
                    onValueChange = uiState.onEmailChange,
                    shape = RoundedCornerShape(20),
                    placeholder = {
                        Text(
                            text = stringResource(R.string.login_placeholder_email),
                            fontSize = 13.sp,
                            color = PlaceholderGenius,
                            fontWeight = FontWeight.SemiBold
                        )
                    },
                    textStyle = TextStyle(color = Color.White, fontWeight = FontWeight.Bold),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next,
                        capitalization = KeyboardCapitalization.Sentences
                    )
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                        .background(
                            Color.Transparent
                        ),
                    label = {
                        Text(
                            text = stringResource(R.string.login_label_password),
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.White,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Normal
                        )
                    },
                    maxLines = 1,
                    isError = passwordError,
                    visualTransformation = if (visibility) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    },
                    trailingIcon = {
                        IconButton(
                            onClick = visibilityChange
                        ) {
                            Icon(
                                imageVector = if (visibility) {
                                    Icons.Outlined.VisibilityOff
                                } else {
                                    Icons.Outlined.Visibility
                                },
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    },
                    value = password,
                    onValueChange = uiState.onPasswordChange,
                    shape = RoundedCornerShape(20),
                    placeholder = {
                        Text(
                            text = stringResource(R.string.login_placeholder_password),
                            fontSize = 13.sp,
                            color = PlaceholderGenius,
                            fontWeight = FontWeight.SemiBold
                        )
                    },
                    textStyle = TextStyle(color = Color.White, fontWeight = FontWeight.Bold),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        capitalization = KeyboardCapitalization.Sentences
                    )
                )

                ClickableText(
                    modifier = Modifier
                        .align(alignment = Alignment.End)
                        .padding(bottom = 55.dp),
                    text = AnnotatedString(stringResource(R.string.login_link_forgot_password)),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White,
                        textDecoration = TextDecoration.Underline
                    ),
                    onClick = { /*TODO*/ }
                )

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(alignment = Alignment.CenterHorizontally)
                        .padding(bottom = 11.dp),
                    onClick = {
                        onLogin()
                    },
                    colors = ButtonDefaults.buttonColors(disabledContentColor = Color.White,
                        disabledContainerColor = Color.Gray
                    ),
                    enabled = if(email.isBlank() || password.isBlank()) false else true,
                    shape = RoundedCornerShape(20)
                ) {
                    Text(
                        text = stringResource(R.string.login_button)
                    )
                }

                ClickableText(
                    text = AnnotatedString(stringResource(R.string.login_link_register)),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White,
                        textDecoration = TextDecoration.Underline
                    ),
                    onClick = {
                        onNavigateToRegister()
                    }
                )
            }
        }
    }
}