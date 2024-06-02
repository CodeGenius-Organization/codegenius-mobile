package com.example.codegenius.feature.aluno.course.view.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codegenius.R
import com.example.codegenius.feature.aluno.course.sampleData.contentModuleMock
import com.example.codegenius.feature.aluno.course.view.ui.components.ModuleDrawer
import com.example.codegenius.feature.aluno.course.view.ui.viewmodels.CourseDetailViewModel
import com.example.codegenius.feature.aluno.shared.ui.components.Navigationbar
import com.example.codegenius.feature.aluno.shared.ui.components.NavigationbarCourse

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LessonTestScreen(
    viewModel: CourseDetailViewModel,
    modifier : Modifier = Modifier,
    onNavigationLessonContent : () -> Unit = {},
    onNavigationLessonExercise : () -> Unit = {},
    onNavigationLessonExerciseTest : () -> Unit = {}
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
                Text(
                    text = stringResource(R.string.test_life_count) + "3", //TODO
                    modifier = Modifier.padding(16.dp),
                    color = Color.White
                )
                Text(
                    text = stringResource(R.string.test_title),
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .fillMaxWidth(),
                    color = Color.Yellow,
                    textAlign = TextAlign.Center,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = stringResource(R.string.test_text),
                    modifier = Modifier
                        .padding(16.dp),
                    color = Color.White
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp, top = 16.dp),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Button(
                        modifier = Modifier
                            .width(130.dp),
                        onClick = { onNavigationLessonExerciseTest() }
                    ) {
                        Text(
                            text = stringResource(R.string.test_button)
                        )
                    }
                }
            }
        }
    }
}

//@Preview
//@Composable
//fun LessonTestScreenPreview() {
//    LessonTestScreen()
//}