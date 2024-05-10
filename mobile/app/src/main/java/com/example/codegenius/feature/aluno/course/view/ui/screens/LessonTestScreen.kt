package com.example.codegenius.feature.aluno.course.view.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codegenius.feature.aluno.course.sampleData.contentModuleMock
import com.example.codegenius.feature.aluno.course.view.ui.components.ModuleDrawer
import com.example.codegenius.feature.aluno.shared.ui.components.Navigationbar
import com.example.codegenius.feature.aluno.shared.ui.components.NavigationbarCourse

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LessonTestScreen(
    modifier : Modifier = Modifier,
    onNavigationLessonContent : () -> Unit = {},
    onNavigationLessonExercise : () -> Unit = {}
){
    ModalNavigationDrawer(
        drawerContent = { ModuleDrawer(moduleModel = contentModuleMock, onNavigationLessonContent = onNavigationLessonContent) }
    ) {
        Scaffold(
            topBar = {
                Column {
                    Navigationbar()
                }
            }
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(Color(red = 12, green = 15, blue = 26))
                    .padding(top = 90.dp)
            ) {
                NavigationbarCourse(test = true, onNagivationLessonContent = onNavigationLessonContent, onNavigationLessonExercise = onNavigationLessonExercise)
            }
        }
    }
}

@Preview
@Composable
fun LessonTestScreenPreview() {
    LessonTestScreen()
}