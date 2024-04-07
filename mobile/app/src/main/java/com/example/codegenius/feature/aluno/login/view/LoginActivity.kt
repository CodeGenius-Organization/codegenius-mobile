package com.example.codegenius.feature.aluno.login.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.codegenius.feature.aluno.login.view.ui.components.LoginBox
import com.example.codegenius.feature.aluno.login.view.ui.screens.LoginScreen

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Login()
        }
    }

    @Composable
    fun Login() {
        MaterialTheme {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                LoginScreen()
            }
        }
    }
}
