package com.example.codegenius.feature.aluno.course.view

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
import com.example.codegenius.feature.aluno.course.view.ui.screens.CourseScreen
import com.example.codegenius.feature.aluno.course.view.ui.screens.LessonContentScreen
import com.example.codegenius.feature.aluno.course.view.ui.screens.LessonExerciseScreen
import com.example.codegenius.feature.aluno.course.view.ui.screens.LessonScreen
import com.example.codegenius.feature.aluno.course.view.ui.screens.LessonTestExerciseScreen
import com.example.codegenius.feature.aluno.course.view.ui.screens.LessonTestScreen
import com.example.codegenius.feature.aluno.course.view.ui.viewmodels.CourseDetailViewModel
import com.example.codegenius.feature.aluno.course.view.ui.viewmodels.CourseScreenViewModel
import com.example.codegenius.feature.aluno.login.ui.LoginActivity
import com.example.codegenius.feature.aluno.navigation.AppDestination
import org.koin.androidx.viewmodel.ext.android.getViewModel

class CourseActivity : ComponentActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = AppDestination.Course.route) {
                    composable(AppDestination.Course.route) {
                        CourseScreen(
                            viewModel = getViewModel<CourseScreenViewModel>(),
                            onNavigateToLesson = {
                                navController.navigate(AppDestination.Lesson.route)
                            },
                            onLogout = {
                                val intent = Intent(this@CourseActivity, LoginActivity::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                startActivity(intent)
                            }
                        )
                    }
                    composable(AppDestination.Lesson.route) {
                        LessonScreen(
                            viewModel = getViewModel<CourseDetailViewModel>(),
                            onNavigationLessonContent = {
                                navController.navigate(AppDestination.LessonContent.route)
                            },
                            onLogout = {
                                val intent = Intent(this@CourseActivity, LoginActivity::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                startActivity(intent)
                            }
                        )
                    }
                    composable(AppDestination.LessonContent.route) {
                        LessonContentScreen(
                            viewModel = getViewModel<CourseDetailViewModel>(),
                            onNavigationLessonContent = {
                                navController.navigate(AppDestination.LessonContent.route)
                            },
                            onNavigationLessonExercise = {
                                navController.navigate(AppDestination.LessonExercise.route)
                            },
                            onNavigationLessonTest = {
                                navController.navigate(AppDestination.LessonTest.route)
                            },
                            onLogout = {
                                val intent = Intent(this@CourseActivity, LoginActivity::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                startActivity(intent)
                            }
                        )
                    }
                    composable(AppDestination.LessonExercise.route) {
                        LessonExerciseScreen(
                            viewModel = getViewModel<CourseDetailViewModel>(),
                            onNavigationLessonContent = {
                                navController.navigate(AppDestination.LessonContent.route)
                            },
                            onNavigationLessonTest = {
                                navController.navigate(AppDestination.LessonTest.route)
                            },
                            onLogout = {
                                val intent = Intent(this@CourseActivity, LoginActivity::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                startActivity(intent)
                            }
                        )
                    }
                    composable(AppDestination.LessonTest.route) {
                        LessonTestScreen(
                            viewModel = getViewModel<CourseDetailViewModel>(),
                            onNavigationLessonContent = {
                                navController.navigate(AppDestination.LessonContent.route)
                            },
                            onNavigationLessonExercise = {
                                navController.navigate(AppDestination.LessonExercise.route)
                            },
                            onNavigationLessonExerciseTest = {
                                navController.navigate(AppDestination.LessonExerciseTest.route)
                            },
                            onLogout = {
                                val intent = Intent(this@CourseActivity, LoginActivity::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                startActivity(intent)
                            }
                        )
                    }
                    composable(AppDestination.LessonExerciseTest.route) {
                        LessonTestExerciseScreen(
                            viewModel = getViewModel<CourseDetailViewModel>(),
                            onNavigationLessonContent = {
                                navController.navigate(AppDestination.LessonContent.route)
                            },
                            onLogout = {
                                val intent = Intent(this@CourseActivity, LoginActivity::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                startActivity(intent)
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