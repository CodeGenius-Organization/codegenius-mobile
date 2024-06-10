package com.example.codegenius.feature.aluno.course.view.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codegenius.feature.aluno.course.sampleData.contentModuleMock
import com.example.codegenius.feature.aluno.course.view.ui.components.ModuleDrawer
import com.example.codegenius.feature.aluno.course.view.ui.viewmodels.CourseDetailViewModel
import com.example.codegenius.feature.aluno.shared.ui.components.Navigationbar
import com.example.codegenius.feature.aluno.shared.ui.components.NavigationbarCourse
import com.example.codegenius.feature.aluno.shared.ui.theme.BackgroundGenius
import com.example.codegenius.feature.aluno.shared.ui.theme.blueLightGenius
import com.example.codegenius.feature.aluno.shared.util.singleton.Util

@Composable
fun LessonTestConcluedScreen(
    onLogout: () -> Unit = {},
    onNavigationLessonContent: () -> Unit = {},
    onNavigationLessonExercise: () -> Unit = {},
    onNavigationLessonTest: () -> Unit = {}
) {
    Scaffold(
        topBar = { Navigationbar(onLogout = onLogout) },
    ) {
        ModalNavigationDrawer(
            modifier = Modifier.padding(it),
            drawerContent = {
                ModuleDrawer(
                    moduleModel = contentModuleMock, // Util.getInstance().modules,
                    onNavigationLessonContent = onNavigationLessonContent
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(red = 12, green = 15, blue = 26))
            ) {
                NavigationbarCourse(test = true, onNavigationLessonExercise = onNavigationLessonExercise, onNavigationLessonTest = onNavigationLessonTest)
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp)
                ){
                    Text(
                        modifier = Modifier.padding(bottom = 10.dp),
                        text = "Pontuação: 0%",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Box(
                        modifier = Modifier
                            .border(2.dp, Color.Red)
                            .padding(15.dp)
                    ) {
                        Text(
                            text = "Infelizmente, você não passou na prova. No entanto, não desanime! Você pode revisar os conteúdos e praticar seu conhecimento nos exercícios quantas vezes forem necessárias e tentar novamente.",
                            color = Color.Red
                        )
                    }
                    Row(
                        modifier = Modifier.padding(top = 10.dp)
                    ) {
                        Text(
                            text = "Prova iniciada às:",
                            color = Color.White
                        )
                        Text(
                            modifier = Modifier.padding(start = 5.dp),
                            text = "16h47",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Row(
                        modifier = Modifier.padding(top = 10.dp)
                    ) {
                        Text(
                            text = "Tempo de duração da prova:",
                            color = Color.White
                        )
                        Text(
                            modifier = Modifier.padding(start = 5.dp),
                            text = "22min 13seg",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Row(
                        modifier = Modifier.padding(top = 10.dp)
                    ) {
                        Text(
                            text = "Tentativas:",
                            color = Color.White
                        )
                        Text(
                            modifier = Modifier.padding(start = 5.dp),
                            text = "1",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Row(
                        modifier = Modifier.padding(top = 10.dp)
                    ) {
                        Text(
                            text = "Quantidade de vida:",
                            color = Color.White
                        )
                        Text(
                            modifier = Modifier.padding(start = 5.dp),
                            text = "2",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(
                                blueLightGenius
                            )
                        ) {
                            Text(
                                text = "Voltar ao curso"
                            )
                        }
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(
                                blueLightGenius
                            )
                        ) {
                            Text(
                                text = "Tentar novamente"
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun LessonTestConcluedScreenPreview() {
    LessonTestConcluedScreen()
}