package com.example.codegenius.feature.aluno.login.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.codegenius.feature.aluno.login.view.ui.screens.LoginScreen
import com.example.codegenius.feature.aluno.login.view.ui.screens.RegisterScreen
import com.example.codegenius.feature.aluno.navigation.AppDestination

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            App() {
                NavHost(navController = navController, startDestination = AppDestination.Login.route) {
                    composable(AppDestination.Login.route) {
                        LoginScreen(onNavigateToRegister = {
                            navController.navigate(AppDestination.Register.route)
                        })
                    }
                    composable(AppDestination.Register.route) {
                        RegisterScreen(onNavigateToLogin = {
                                navController.navigate(AppDestination.Login.route)
                            }
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun App(
        content: @Composable () -> Unit
    ) {
        MaterialTheme {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                content()
            }
        }
    }
}
