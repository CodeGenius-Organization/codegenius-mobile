package com.example.codegenius.feature.aluno.course.view.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.codegenius.feature.aluno.course.model.LessonContentModel

@Composable
fun LessonScreen(
    modifier: Modifier = Modifier,
    lessonContent: LessonContentModel? = null
) {

}

@Preview(showSystemUi = true)
@Composable
fun LessonScreenPreview() {
    LessonScreen()
}