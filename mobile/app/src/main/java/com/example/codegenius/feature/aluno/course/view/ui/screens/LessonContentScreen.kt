package com.example.codegenius.feature.aluno.course.view.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codegenius.R
import com.example.codegenius.feature.aluno.course.model.ModuleLessonModel
import com.example.codegenius.feature.aluno.course.sampleData.contentModuleMock
import com.example.codegenius.feature.aluno.course.view.ui.components.ModuleDrawer
import com.example.codegenius.feature.aluno.shared.ui.components.Navigationbar
import com.example.codegenius.feature.aluno.shared.ui.components.NavigationbarCourse

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LessonContentScreen(
    modifier : Modifier = Modifier,
    moduleLessonModel : ModuleLessonModel = contentModuleMock.get(0)
        .moduleLessonModel.get(0),
    onNavigationLessonContent : () -> Unit = {}
) {
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
                NavigationbarCourse(content = true)
                LazyColumn {
                    item {
                        Text(
                            text = stringResource(R.string.course_description_label),
                            modifier = Modifier
                                .padding(
                                    start = 16.dp, end = 16.dp, top = 20.dp, bottom = 30.dp
                                )
                                .fillMaxWidth(),
                            color = Color.White,
                            fontSize = 23.sp,
                            fontWeight = FontWeight(400)
                        )
                    }
                    item {
                        Text(
                            text = moduleLessonModel.lessonContentModel.content,
                            modifier = Modifier
                                .padding(
                                    start = 16.dp, end = 16.dp, bottom = 25.dp
                                )
                                .fillMaxWidth(),
                            color = Color.White,
                            fontSize = 16.sp

                        )
                    }
                }
            }
        }
    }
}

@Preview()
@Composable
fun LessonContentScreenPreview() {
    LessonContentScreen(
        moduleLessonModel = contentModuleMock.get(0)
            .moduleLessonModel.get(0)
    )
}