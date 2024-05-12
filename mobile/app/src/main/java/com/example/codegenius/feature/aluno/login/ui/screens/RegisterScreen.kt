package com.example.codegenius.feature.aluno.login.ui.screens

import android.util.Log
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
import com.example.codegenius.feature.aluno.login.ui.states.LoginScreenState
import com.example.codegenius.feature.aluno.login.ui.states.RegisterScreenState
import com.example.codegenius.feature.aluno.login.ui.states.RegisterScreenUiState
import com.example.codegenius.feature.aluno.login.ui.viewmodels.LoginScreenViewModel
import com.example.codegenius.feature.aluno.login.ui.viewmodels.RegisterScreenViewModel
import com.example.codegenius.feature.aluno.shared.ui.theme.BackgroundGenius
import com.example.codegenius.feature.aluno.shared.ui.theme.PlaceholderGenius

@Composable
fun RegisterScreen(
    viewModel: RegisterScreenViewModel,
    onNavigateToLogin: () -> Unit = {},
    ) {
    val uiState by viewModel.uiState.collectAsState()

    RegisterScreen(
        uiState = uiState,
        visibilityChange = {
            viewModel.visibilityChange()
        },
        visiConfirmPassChange = {
            viewModel.visibilityConfirmPassChange()
        },
        onNavigateToLogin = onNavigateToLogin,
        onRegister = { viewModel.postRegister(onNavigateToLogin) }
    )
}

@Composable
fun RegisterScreen(
    uiState: RegisterScreenUiState = RegisterScreenUiState(),
    visibilityChange: () -> Unit,
    visiConfirmPassChange: () -> Unit,
    onRegister: () -> Unit,
    onNavigateToLogin: () -> Unit = {}
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundGenius)
            .padding(bottom = 20.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        val name = uiState.name
        val lastName = uiState.lastName
        val email = uiState.email
        val password = uiState.password
        val confirmPassword = uiState.confirmPassword
        val visibilityPassword = uiState.visibilityPassword
        val visibilityConfirmPass = uiState.visibilityConfirmPass

        CorporateInsignia(Modifier.padding(28.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .verticalScroll(rememberScrollState())
        ) {

            Text(
                modifier = Modifier.padding(bottom = 32.dp),
                text = stringResource(R.string.register_label_welcome),
                style = MaterialTheme.typography.titleMedium,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
                    .background(
                        Color.Transparent
                    ),
                maxLines = 1,
                label = {
                    Text(
                        text = stringResource(R.string.register_label_name),
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Normal
                    )
                },
                value = name,
                onValueChange = uiState.onNameChange,
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
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words
                )
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
                    .background(
                        Color.Transparent
                    ),
                maxLines = 1,
                label = {
                    Text(
                        text = stringResource(R.string.register_label_lastname),
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Normal
                    )
                },
                value = lastName,
                onValueChange = uiState.onLastNameChange,
                shape = RoundedCornerShape(20),
                placeholder = {
                    Text(
                        text = stringResource(R.string.register_placeholder_lastname),
                        fontSize = 13.sp,
                        color = PlaceholderGenius,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                textStyle = TextStyle(color = Color.White, fontWeight = FontWeight.Bold),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words
                )
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
                    .background(
                        Color.Transparent
                    ),
                maxLines = 1,
                label = {
                    Text(
                        text = stringResource(R.string.register_label_email),
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
                        text = stringResource(R.string.register_placeholder_email),
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
                        text = stringResource(R.string.register_label_password),
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Normal
                    )
                },
                maxLines = 1,
                visualTransformation = if (visibilityPassword) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                trailingIcon = {
                    IconButton(
                        onClick = {
                            visibilityChange()
                        }
                    ) {
                        Icon(
                            imageVector = if (visibilityPassword) {
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
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Sentences
                )
            )


            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 46.dp)
                    .background(
                        Color.Transparent
                    ),
                label = {
                    Text(
                        text = stringResource(R.string.register_label_confirm_password),
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Normal
                    )
                },
                maxLines = 1,
                visualTransformation = if (visibilityConfirmPass) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                trailingIcon = {
                    IconButton(
                        onClick = {
                            visiConfirmPassChange()
                        }
                    ) {
                        Icon(
                            imageVector = if (visibilityConfirmPass) {
                                Icons.Outlined.VisibilityOff
                            } else {
                                Icons.Outlined.Visibility
                            },
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                },
                value = confirmPassword,
                onValueChange = uiState.onConfirmPasswordChange,
                shape = RoundedCornerShape(20),
                placeholder = {
                    Text(
                        text = stringResource(R.string.register_placeholder_confirm_password),
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

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(bottom = 11.dp),
                shape = RoundedCornerShape(20),
                onClick = {
                    Log.d("###API", "Tentando cadastrar")
                     onRegister()
                }
            ) {
                Text(text = stringResource(R.string.register_button))
            }

            ClickableText(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    textDecoration = TextDecoration.Underline
                ),
                text = AnnotatedString(stringResource(R.string.register_link_login)),
                onClick = {
                    onNavigateToLogin()
                }
            )
        }
    }
}

