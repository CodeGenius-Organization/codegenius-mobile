package com.example.codegenius.feature.aluno.login.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codegenius.feature.aluno.login.ui.components.CorporateInsignia
import com.example.codegenius.feature.aluno.login.ui.components.RegisterBox
import com.example.codegenius.feature.aluno.shared.ui.theme.BackgroundGenius

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    onNavigateToLogin: () -> Unit= {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(BackgroundGenius)
    ) {
        CorporateInsignia(
            Modifier.padding(60.dp)
        )
        RegisterBox(onNavigateToLogin = onNavigateToLogin)
    }
}

@Preview(showSystemUi = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen()
}