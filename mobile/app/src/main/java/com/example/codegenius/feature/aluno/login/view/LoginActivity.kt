package com.example.codegenius.feature.aluno.login.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.codegenius.feature.aluno.login.view.screens.LoginScreen
import com.example.codegenius.feature.aluno.login.view.screens.RegisterScreen
import com.example.codegenius.feature.aluno.course.view.CourseActivity
import com.example.codegenius.feature.aluno.navigation.AppDestination

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            App {
                NavHost(navController = navController, startDestination = AppDestination.Login.route) {
                    composable(AppDestination.Login.route) {
                        LoginScreen(onNavigateToRegister = {
                                navController.navigate(AppDestination.Register.route)
                            }, onNavigateToCourse = {
                                startActivity(Intent(this@LoginActivity, CourseActivity::class.java))
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
