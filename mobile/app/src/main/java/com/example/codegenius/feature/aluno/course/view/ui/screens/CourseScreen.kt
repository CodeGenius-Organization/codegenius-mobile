package com.example.codegenius.feature.aluno.course.view.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codegenius.feature.aluno.course.model.CourseModel
import com.example.codegenius.feature.aluno.course.sampleData.contentCoursesMock
import com.example.codegenius.feature.aluno.course.view.ui.components.CourseContentList
import com.example.codegenius.feature.aluno.shared.ui.components.Navigationbar

val categories = listOf(
    "Backend",
    "Database",
    "Frontend",
    "Mobile",
    "Security"
)

@Composable
fun CourseScreen(
    modifier: Modifier = Modifier,
    courseModel: List<CourseModel> = contentCoursesMock //TODO
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(red = 12, green = 15, blue = 26))
    ) {
        Navigationbar()
        LazyColumn(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
        categories.forEach { category ->
            val coursesInCategory = getCoursesForCategory(category, courseModel)
            if (coursesInCategory.isNotEmpty()) {
                    item {
                        CourseContentList(
                            title= category,
                            courseModel = coursesInCategory
                        )
                    }
                }
            }
        }
    }
}

fun getCoursesForCategory(categoryName: String, courseModel: List<CourseModel>): List<CourseModel> {
    return courseModel.filter { course ->
        course.categoryModel.any { it.category == categoryName }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CourseScreenPreview() {
    CourseScreen(courseModel = contentCoursesMock)
}