package com.example.codegenius.feature.aluno.course.view.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.codegenius.feature.aluno.course.model.CourseModel
import com.example.codegenius.feature.aluno.course.view.ui.components.CourseContentList
import com.example.codegenius.feature.aluno.course.view.ui.states.CourseScreenState
import com.example.codegenius.feature.aluno.course.view.ui.viewmodels.CourseScreenViewModel
import com.example.codegenius.feature.aluno.shared.ui.components.Navigationbar

val categories = listOf(
    "Web",
    "Backend",
    "Database",
    "Frontend",
    "Mobile",
    "Security"
)

@Composable
fun CourseScreen(
    viewModel: CourseScreenViewModel,
    onLogout: () -> Unit,
    onNavigateToLesson: () -> Unit
) {
    viewModel.getAllCourse()
    viewModel.getUserByEmail()
    val state by viewModel.state.observeAsState()

    Scaffold(
        topBar = { Navigationbar(onLogout = onLogout) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(red = 12, green = 15, blue = 26))
                .padding(paddingValues = it)
        ) {
            when (state) {
                is CourseScreenState.Loading -> {
                    Text(text = "Loading")
                }

                is CourseScreenState.Error -> {
                    Text(text = "Error")
                }

                is CourseScreenState.Success -> {
                    val data = (state as CourseScreenState.Success).data
                    Column(
                        Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                        categories.forEach { category ->
                            val coursesInCategory = getCoursesForCategory(category, data)
                            if (coursesInCategory.isNotEmpty()) {
                                CourseContentList(
                                    title = category,
                                    courseModel = coursesInCategory,
                                    onNavigateToLesson = onNavigateToLesson
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

}


fun getCoursesForCategory(categoryName: String, courseModel: List<CourseModel>): List<CourseModel> {
    return courseModel.filter { course ->
        course.categories.any { it.category == categoryName }
    }
}

//@Preview()
//@Composable
//fun CourseScreenPreview() {
//    CourseScreen(courseModel = contentCoursesMock)
//}