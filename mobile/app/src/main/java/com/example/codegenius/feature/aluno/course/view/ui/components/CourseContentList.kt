package com.example.codegenius.feature.aluno.course.view.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codegenius.feature.aluno.course.model.CourseModel
import com.example.codegenius.feature.aluno.course.sampleData.contentCoursesMock

@Composable
fun CourseContentList(
    title: String,
    modifier: Modifier = Modifier,
    courseModel: List<CourseModel>,
    onNavigateToLesson : () -> Unit = {}
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            modifier = Modifier
                .padding(
                    start = 16.dp, end = 16.dp
                )
                .fillMaxWidth(),
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
        HorizontalDivider(
            modifier = Modifier
                .padding(
                    start = 16.dp, end = 16.dp
                )
                .height(1.dp)
                .fillMaxWidth(),
            color = Color(0xFFD868FF)
        )
        LazyRow(
            modifier = Modifier
                .padding(
                    top = 8.dp,
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(courseModel) { course ->
                CourseContent(courseModel = course, onNavigateToLesson = onNavigateToLesson)
            }
        }
    }
}

@Preview
@Composable
fun CourseContentListPreview() {
    CourseContentList(
        title = "Todos os cursos",
        courseModel = contentCoursesMock
    )
}