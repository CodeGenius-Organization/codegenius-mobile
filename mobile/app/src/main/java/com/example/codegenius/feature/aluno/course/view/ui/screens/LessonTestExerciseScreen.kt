package com.example.codegenius.feature.aluno.course.view.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codegenius.R
import com.example.codegenius.feature.aluno.course.model.QuestionModel
import com.example.codegenius.feature.aluno.course.sampleData.contentModuleMock
import com.example.codegenius.feature.aluno.course.sampleData.contentQuestionMock
import com.example.codegenius.feature.aluno.course.view.ui.components.ModuleDrawer
import com.example.codegenius.feature.aluno.shared.ui.components.Navigationbar
import com.example.codegenius.feature.aluno.shared.ui.components.NavigationbarCourse
import java.util.UUID

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LessonTestExerciseScreen(
    modifier : Modifier = Modifier,
    onNavigationLessonContent : () -> Unit = {},
    onNavigationLessonExercise : () -> Unit = {},
    questionModel: List<QuestionModel>
){
    val selectedResponseMap = remember { mutableMapOf<UUID, UUID?>() }

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
                    text = stringResource(R.string.test_time_count) + "00:00:00", //TODO
                    modifier = Modifier.padding(16.dp),
                    color = Color.White
                )
                LazyColumn {
                    itemsIndexed(questionModel) { index, question ->
                        Text(
                            text = "Questão ${index + 1}- ${question.statement}",
                            modifier = Modifier.padding(16.dp),
                            color = Color.White
                        )
                        question.responseModel.forEach { response ->
                            Row(
                                modifier = Modifier.padding(top = 8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Checkbox(
                                    checked = selectedResponseMap[question.id] == response.id,
                                    onCheckedChange = {
                                        selectedResponseMap[question.id] = response.id
                                    },
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = Color.White,
                                        uncheckedColor = Color.White
                                    )
                                )
                                Text(
                                    text = response.answer,
                                    modifier = Modifier.padding(start = 8.dp),
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp, top = 16.dp),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Button(
                        modifier = Modifier
                            .width(130.dp),
                        onClick = { onNavigationLessonContent() }
                    ) {
                        Text(
                            text = stringResource(R.string.test_exercise_button)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun LessonTestExerciseScreenPreview() {
    LessonTestExerciseScreen(questionModel = contentQuestionMock)
}