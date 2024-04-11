package com.example.codegenius.feature.aluno.login.view.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codegenius.feature.aluno.login.view.ui.components.CorporateInsignia
import com.example.codegenius.feature.aluno.login.view.ui.components.LoginBox
import com.example.codegenius.feature.aluno.shared.ui.theme.BackgroundGenius

@Composable
<<<<<<< HEAD
fun LoginScreen() {
=======
fun LoginScreen(
    modifier: Modifier = Modifier,
    onNavigateToRegister: () -> Unit= {}
) {
>>>>>>> c10111ba234163742c94d0248298d56702702415
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(BackgroundGenius),
        verticalArrangement = Arrangement.spacedBy(
            space = 85.dp,
            alignment = Alignment.CenterVertically
        )
    ) {
        CorporateInsignia(
            Modifier.padding(60.dp)
        )
        LoginBox(onNavigateToRegister = onNavigateToRegister)
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}