package com.example.codegenius.feature.aluno.course.view.ui.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codegenius.R
import com.example.codegenius.feature.aluno.course.sampleData.contentModuleMock
import com.example.codegenius.feature.aluno.course.view.ui.components.ModuleDrawer
import com.example.codegenius.feature.aluno.course.view.ui.states.CourseDetailState
import com.example.codegenius.feature.aluno.course.view.ui.states.CourseScreenState
import com.example.codegenius.feature.aluno.course.view.ui.viewmodels.CourseDetailViewModel
import com.example.codegenius.feature.aluno.shared.ui.components.Navigationbar
import com.example.codegenius.feature.aluno.shared.ui.theme.BackgroundGenius

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LessonScreen(
    viewModel: CourseDetailViewModel,
    onLogout: () -> Unit,
    onNavigationLessonContent: () -> Unit = {}
) {
    viewModel.getCourseDetail();

    val state by viewModel.state.observeAsState()
    Scaffold(
        topBar = { Navigationbar(onLogout = onLogout) },
        modifier = Modifier.background(BackgroundGenius)
    ) {

        when (state) {
            is CourseDetailState.Loading -> {
                Text(text = "Loading")
            }

            is CourseDetailState.Error -> {
                Text(text = "Error")
            }

            is CourseDetailState.Success -> {
                val data = (state as CourseDetailState.Success).data
                ModalNavigationDrawer(
                    modifier = Modifier.padding(it),
                    drawerContent = {
                        ModuleDrawer(
                            moduleModel = data.modules.toList(),
                            onNavigationLessonContent = onNavigationLessonContent
                        )
                    }
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(BackgroundGenius)
                            .padding(top = 10.dp)
                    ) {
                        val data = (state as CourseDetailState.Success).data
                        Column(
                            modifier = Modifier
                                .padding(
                                    top = 8.dp,
                                )
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = stringResource(R.string.modulo_description_label),
                                modifier = Modifier
                                    .padding(start = 16.dp, end = 16.dp, bottom = 30.dp)
                                    .fillMaxWidth(),
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(400)
                            )

                            Text(
                                text = data.title,
                                modifier = Modifier
                                    .padding(horizontal = 16.dp)
                                    .fillMaxWidth(),
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(400)
                            )
                            Text(
                                text = data.courseDescription,
                                modifier = Modifier
                                    .padding(horizontal = 16.dp)
                                    .fillMaxWidth(),
                                color = Color.White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(400)
                            )
                            Text(
                                text = data.contentDescription,
                                modifier = Modifier
                                    .padding(horizontal = 16.dp)
                                    .fillMaxWidth(),
                                color = Color.White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(400)
                            )
                        }
                    }

                }
            }

            else -> {
                Log.d("## Erro", "lukinhas")
            }
        }
    }
}