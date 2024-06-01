package com.example.codegenius.feature.aluno.login.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codegenius.R
import com.example.codegenius.feature.aluno.login.ui.components.CorporateInsignia
import com.example.codegenius.feature.aluno.login.ui.states.RegisterScreenUiState
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
        val nameError = uiState.nameError
        val lastNameError = uiState.lastNameError
        val emaiError = uiState.emailError
        val passError = uiState.passError
        val confirmPassError = uiState.confirmPassError
        val lastName = uiState.lastName
        val email = uiState.email
        val password = uiState.password
        val confirmPassword = uiState.confirmPassword
        val visibilityPassword = uiState.visibilityPassword
        val visibilityConfirmPass = uiState.visibilityConfirmPass
        val checked = uiState.checked
        val snackbarHostState = uiState.snackbarHostState
        val showDialog = uiState.showDialog

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
                        isError = nameError,
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
                        isError = lastNameError,
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
                        isError = emaiError,
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
                        isError = passError,
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
                            .padding(bottom = 10.dp)
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
                        isError = confirmPassError,
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
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Checkbox(
                            checked = checked,
                            onCheckedChange = uiState.onCheck
                        )
                        Text(
                            text = AnnotatedString(stringResource(R.string.register_accept_message)),
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.White,
                            ),
                        )
                        ClickableText(
                            modifier = Modifier.padding(start = 3.dp),
                            text = AnnotatedString(stringResource(R.string.register_term_use)),
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Blue,
                                textDecoration = TextDecoration.Underline
                            ),
                            onClick = {
                                uiState.onShowDialog(true)
                            }
                        )
                    }

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(alignment = Alignment.CenterHorizontally)
                            .padding(bottom = 11.dp),
                        shape = RoundedCornerShape(20),
                        enabled = if (name.isNotBlank() && lastName.isNotBlank() && email.isNotBlank() && password.isNotBlank() && confirmPassword.isNotBlank() && checked) true else false,
                        colors = ButtonDefaults.buttonColors(
                            disabledContentColor = Color.White,
                            disabledContainerColor = Color.Gray
                        ),
                        onClick = {
                            Log.d("###API", "Tentando cadastrar")
                            onRegister()
                        }
                    ) {
                        // logica if else para mostrar o loading
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

                    if (showDialog) {
                        AlertDialog(
                            icon = {
                                Icon(
                                    imageVector = Icons.Filled.Security,
                                    contentDescription = "Icone de termo"
                                )
                            },
                            title = {
                                Text(
                                    text = stringResource(R.string.dialog_title_term),
                                    fontSize = 18.sp,
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight(700),
                                    maxLines = 3,
                                    overflow = TextOverflow.Ellipsis
                                )
                            },
                            text = {
                                Column(
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .verticalScroll(rememberScrollState())
                                ) {
                                Text(
                                    text = stringResource(R.string.dialog_body_term),
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight(400),
                                    overflow = TextOverflow.Ellipsis
                                )
                                }
                            },
                            onDismissRequest = {
                                uiState.onShowDialog(false)
                            },
                            confirmButton = {
                                TextButton(
                                    onClick = {
                                        uiState.onCheck(true)
                                        uiState.onShowDialog(false)
                                    }
                                ) {
                                    Text(
                                        text = stringResource(R.string.dialog_button_accept),
                                        color = Color.Black,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight(700),
                                    )
                                }
                            },
                            dismissButton = {
                                TextButton(
                                    onClick = {  uiState.onShowDialog(false) }
                                ) {
                                    Text(
                                        text = stringResource(R.string.dialog_button_dismiss),
                                        color = Color.Black,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight(700),
                                    )
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

