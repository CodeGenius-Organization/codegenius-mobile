package com.example.codegenius.feature.aluno.course.view

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
import com.example.codegenius.feature.aluno.course.sampleData.contentModuleMock
import com.example.codegenius.feature.aluno.course.view.ui.screens.CourseScreen
import com.example.codegenius.feature.aluno.course.view.ui.screens.LessonScreen
import com.example.codegenius.feature.aluno.course.view.ui.screens.ModuleScreen
import com.example.codegenius.feature.aluno.navigation.AppDestination


class CourseActivity : ComponentActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = AppDestination.Course.route) {
                    composable(AppDestination.Course.route) {
                        CourseScreen()
                    }
                    composable(AppDestination.Module.route) {
                        ModuleScreen(
                            moduleModel = contentModuleMock
                        )
                    }
                    composable(AppDestination.Lesson.route) {
                        LessonScreen(
                            lessonContent = contentModuleMock
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