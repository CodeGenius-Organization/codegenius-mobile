package com.example.codegenius.feature.aluno.course.view.ui.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
import com.example.codegenius.feature.aluno.course.view.ui.states.CourseDetailState
import com.example.codegenius.feature.aluno.course.view.ui.states.HeartState
import com.example.codegenius.feature.aluno.course.view.ui.viewmodels.CourseDetailViewModel
import com.example.codegenius.feature.aluno.shared.ui.components.Navigationbar
import com.example.codegenius.feature.aluno.shared.ui.components.NavigationbarCourse
import com.example.codegenius.feature.aluno.shared.util.singleton.Util

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LessonTestScreen(
    viewModel: CourseDetailViewModel,
    modifier: Modifier = Modifier,
    onNavigationLessonContent: () -> Unit = {},
    onNavigationLessonExercise: () -> Unit = {},
    onLogout: () -> Unit,
    onNavigationLessonExerciseTest: () -> Unit = {}
) {
    viewModel.getHeart();

    val state by viewModel.heartState.observeAsState()
    Scaffold(
        topBar = {
            Column {
                Navigationbar(onLogout = onLogout)
            }
        }
    ) {
        ModalNavigationDrawer(
            modifier = Modifier.padding(it),
            drawerContent = {
                ModuleDrawer(
                    moduleModel = Util.getInstance().modules,
                    onNavigationLessonContent = onNavigationLessonContent
                )
            }
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(Color(red = 12, green = 15, blue = 26))
            ) {
                NavigationbarCourse(
                    test = true,
                    onNagivationLessonContent = onNavigationLessonContent,
                    onNavigationLessonExercise = onNavigationLessonExercise
                )
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        text = stringResource(R.string.test_life_count),
                        modifier = Modifier.padding(16.dp),
                        color = Color.White
                    )
                    when (state) {
                        is HeartState.Loading -> {
                            Text(text = "Loading")
                        }

                        is HeartState.Error -> {
                            Text(text = "Error")
                        }

                        is HeartState.Success -> {
                            val data = (state as HeartState.Success).data
                            Text(
                                text = data.hearts.toString(),
                                modifier = Modifier.padding(16.dp),
                                color = Color.White
                            )
                        }

                        else -> {
                            Log.d("## Erro", "lukinhas")
                        }
                    }
                }
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