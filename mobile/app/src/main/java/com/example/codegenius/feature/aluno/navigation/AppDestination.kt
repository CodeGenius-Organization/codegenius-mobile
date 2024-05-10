package com.example.codegenius.feature.aluno.navigation;

sealed class AppDestination(val route: String) {
    object Login: AppDestination("login")
    object Register: AppDestination("register")
    object Loading: AppDestination("loading")
    object Course: AppDestination("course")
    object Lesson: AppDestination("lesson")
    object LessonContent: AppDestination("lessonContent")
    object LessonExercise: AppDestination("lessonExercise")
    object LessonTest: AppDestination("lessonTest")
}
