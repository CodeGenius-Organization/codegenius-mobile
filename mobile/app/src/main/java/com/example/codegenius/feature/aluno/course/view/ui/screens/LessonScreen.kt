package com.example.codegenius.feature.aluno.course.view.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.codegenius.feature.aluno.course.model.LessonContentModel
import com.example.codegenius.feature.aluno.course.model.ModuleLessonModel
import com.example.codegenius.feature.aluno.course.model.ModuleModel
import com.example.codegenius.feature.aluno.course.sampleData.contentModuleMock
import com.example.codegenius.feature.aluno.course.view.ui.components.ModuleContentList
import com.example.codegenius.feature.aluno.course.view.ui.components.ModuleDescription
import com.example.codegenius.feature.aluno.course.view.ui.components.ModuleDrawer
import com.example.codegenius.feature.aluno.shared.ui.components.Navigationbar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LessonScreen(
    modifier: Modifier = Modifier,
    lessonContent: List<ModuleModel>
) {
    ModalNavigationDrawer(
        drawerContent = { ModuleDrawer(moduleModel = contentModuleMock) }
    ) {
        Scaffold(
            topBar = { Navigationbar() }
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(Color(red = 12, green = 15, blue = 26))
                    .padding(top = 100.dp)
            ) {
                Text(
                    text = stringResource(R.string.modulo_description_label),
                    modifier = Modifier
                        .padding(
                            start = 16.dp, end = 16.dp, bottom = 30.dp
                        )
                        .fillMaxWidth(),
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight(400)
                )
                LazyColumn(
                    modifier = Modifier
                        .padding(
                            top = 8.dp,
                        )
                        .fillMaxWidth()
                ) {
                    items(lessonContent.sortedBy { it.moduleOrder }) { moduleModel ->
                        Text(
                            text = moduleModel.name + ":",
                            modifier = Modifier
                                .padding(
                                    start = 16.dp, end = 16.dp
                                )
                                .fillMaxWidth(),
                            color = Color.White,
                            fontSize = 23.sp,
                            fontWeight = FontWeight(400)
                        )
                        val sortedLessons = moduleModel.moduleLessonModel.sortedBy { it.lessonOrder }
                        sortedLessons.forEachIndexed { index, moduleLesson ->
                            ModuleDescription(
                                lessonContentModel = moduleLesson.lessonContentModel
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview()
@Composable
fun LessonScreenPreview() {
    LessonScreen(
        lessonContent = contentModuleMock
    )
}