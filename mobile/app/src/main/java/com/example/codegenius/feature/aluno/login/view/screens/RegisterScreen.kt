package com.example.codegenius.feature.aluno.login.view.screens

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
<<<<<<< HEAD:mobile/app/src/main/java/com/example/codegenius/feature/aluno/login/view/screens/RegisterScreen.kt
import com.example.codegenius.feature.aluno.login.view.components.CorporateInsignia
import com.example.codegenius.feature.aluno.login.view.components.RegisterBox
=======
import com.example.codegenius.feature.aluno.login.view.ui.components.CorporateInsignia
import com.example.codegenius.feature.aluno.login.view.ui.components.RegisterBox
import com.example.codegenius.feature.aluno.shared.ui.theme.BackgroundGenius
>>>>>>> d566aa17eade79b978d58df05bef94cf2dc8c336:mobile/app/src/main/java/com/example/codegenius/feature/aluno/login/view/ui/screens/RegisterScreen.kt

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