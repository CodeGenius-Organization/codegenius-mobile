package com.example.codegenius.feature.aluno.course.view.ui.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.codegenius.R
import com.example.codegenius.feature.aluno.course.view.ui.components.ModuleDrawer
import com.example.codegenius.feature.aluno.course.view.ui.states.CourseDetailState
import com.example.codegenius.feature.aluno.course.view.ui.viewmodels.CourseDetailViewModel
import com.example.codegenius.feature.aluno.shared.ui.components.Navigationbar
import com.example.codegenius.feature.aluno.shared.ui.components.NavigationbarCourse
import com.example.codegenius.feature.aluno.shared.util.singleton.Util

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LessonExerciseScreen(
    viewModel: CourseDetailViewModel,
    modifier: Modifier = Modifier,
    onNavigationLessonContent: () -> Unit = {},
    onNavigationLessonTest: () -> Unit = {},
    onLogout: () -> Unit,
) {

    viewModel.getListExercices();

    val state by viewModel.state.observeAsState()
    val userResponses = remember {
        mutableStateOf<List<UserResponse>>(emptyList())
    }
    val formsCorrection = remember {
        mutableStateOf(false)
    }
    val checkboxesEnabled = remember { mutableStateOf(true) }

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
                    exercise = true,
                    onNagivationLessonContent = onNavigationLessonContent,
                    onNavigationLessonTest = onNavigationLessonTest
                )
                LazyColumn {
                    when (state) {
                        is CourseDetailState.Loading -> {
                            item {
                                Text(text = "Loading")
                            }
                        }

                        is CourseDetailState.Error -> {
                            item {
                                Text(text = "Error")
                            }
                        }

                        is CourseDetailState.ExercicesSuccess -> {
                            val data = (state as CourseDetailState.ExercicesSuccess).data
                            itemsIndexed(data) { indexQuestion, question ->
                                Text(
                                    text = "Questão ${indexQuestion + 1}- ${question.statement}",
                                    modifier = Modifier.padding(10.dp),
                                    color = Color.White
                                )
                                question.respostas.forEachIndexed { indexResponse, response ->
                                    val isChecked = userResponses.value.any {
                                        it.questionIndex == indexQuestion && it.responseIndex == indexResponse && it.isChecked
                                    }
                                    Row(
                                        modifier = Modifier.padding(bottom = 4.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Checkbox(
                                            checked = isChecked,
                                            onCheckedChange = {
                                                updateUserResponses(
                                                    userResponses,
                                                    indexQuestion,
                                                    indexResponse,
                                                    formsCorrection
                                                )
                                            },
                                            enabled = checkboxesEnabled.value
                                        )
                                        Text(
                                            text = response.resposta,
                                            modifier = Modifier.padding(start = 8.dp),
                                            color = Color.White
                                        )
                                    }
                                    if (formsCorrection.value && isChecked) {
                                        val color =
                                            if (response.correta) Color.Green else Color.Red

                                        Text(
                                            text = response.explicacao,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(horizontal = 20.dp)
                                                .border(2.dp, color)
                                                .padding(10.dp),
                                            color = color,
                                            textAlign = TextAlign.Justify
                                        )
                                    }
                                }
                            }
                        }

                        else -> {
                            Log.d("## Erro", "lukinhas")
                        }
                    }
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp, top = 16.dp),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            Button(
                                onClick = {
                                    if(checkboxesEnabled.value){
                                    formsCorrection.value = true
                                    checkboxesEnabled.value = false
                                    } else {
                                        formsCorrection.value = false
                                        checkboxesEnabled.value = true
                                        userResponses.value = emptyList()
                                    }
                                }
                            ) {
                                Text(
                                    text = if(checkboxesEnabled.value) stringResource(R.string.exercise_button) else "Tentar Novamente"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

data class UserResponse(
    val questionIndex: Int,
    val responseIndex: Int,
    val isChecked: Boolean,
    val isCorrect: Boolean?
)

private fun updateUserResponses(
    userResponses: MutableState<List<UserResponse>>,
    questionIndex: Int,
    responseIndex: Int,
    formsCorrection: MutableState<Boolean>,
) {
    val currentResponses = userResponses.value.toMutableList()
    currentResponses.removeAll { it.questionIndex == questionIndex }
    currentResponses.add(UserResponse(questionIndex, responseIndex, true, null))
    userResponses.value = currentResponses
    formsCorrection.value = false
}


//@Preview
//@Composable
//fun LessonExerciseScreenPreview() {
//    LessonExerciseScreen(
//        questionModel = contentQuestionMock
//    )
//}