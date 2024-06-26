package com.example.codegenius.feature.aluno.course.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.codegenius.feature.aluno.course.sampleData.contentCoursesMock
import com.example.codegenius.feature.aluno.course.sampleData.contentModuleMock
import com.example.codegenius.feature.aluno.course.sampleData.contentQuestionMock
import com.example.codegenius.feature.aluno.course.view.ui.screens.CourseScreen
import com.example.codegenius.feature.aluno.course.view.ui.screens.LessonContentScreen
import com.example.codegenius.feature.aluno.course.view.ui.screens.LessonExerciseScreen
import com.example.codegenius.feature.aluno.course.view.ui.screens.LessonScreen
import com.example.codegenius.feature.aluno.course.view.ui.screens.LessonTestExerciseScreen
import com.example.codegenius.feature.aluno.course.view.ui.screens.LessonTestScreen
import com.example.codegenius.feature.aluno.course.view.ui.viewmodels.CourseDetailViewModel
import com.example.codegenius.feature.aluno.course.view.ui.viewmodels.CourseScreenViewModel
import com.example.codegenius.feature.aluno.login.ui.viewmodels.LoginScreenViewModel
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
                            courseModel = contentCoursesMock,
                            onNavigateToLesson = {
                                navController.navigate(AppDestination.Lesson.route)
                            }
                        )
                    }
                    composable(AppDestination.Lesson.route) {
                        LessonScreen(
                            viewModel = getViewModel<CourseDetailViewModel>(),
                            lessonContent = contentModuleMock,
                            onNavigationLessonContent = {
                                navController.navigate(AppDestination.LessonContent.route)
                            }
                        )
                    }
                    composable(AppDestination.LessonContent.route) {
                        LessonContentScreen(
                            viewModel = getViewModel<CourseDetailViewModel>(),
                            moduleLessonModel = contentModuleMock.get(0).moduleLessonModel.get(0),
                            onNavigationLessonContent = {
                                navController.navigate(AppDestination.LessonContent.route)
                            },
                            onNavigationLessonExercise = {
                                navController.navigate(AppDestination.LessonExercise.route)
                            },
                            onNavigationLessonTest = {
                                navController.navigate(AppDestination.LessonTest.route)
                            }
                        )
                    }
                    composable(AppDestination.LessonExercise.route) {
                        LessonExerciseScreen(
                            viewModel = getViewModel<CourseDetailViewModel>(),
                            questionModel = contentQuestionMock,
                            onNavigationLessonContent = {
                                navController.navigate(AppDestination.LessonContent.route)
                            },
                            onNavigationLessonTest = {
                                navController.navigate(AppDestination.LessonTest.route)
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
                            }
                        )
                    }
                    composable(AppDestination.LessonExerciseTest.route) {
                        LessonTestExerciseScreen(
                            viewModel = getViewModel<CourseDetailViewModel>(),
                            questionModel = contentQuestionMock,
                            onNavigationLessonExercise = {
                                navController.navigate(AppDestination.LessonExercise.route)
                            },
                            onNavigationLessonContent = {
                                navController.navigate(AppDestination.LessonContent.route)
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