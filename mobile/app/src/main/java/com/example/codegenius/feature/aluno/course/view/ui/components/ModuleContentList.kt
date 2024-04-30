package com.example.codegenius.feature.aluno.course.view.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codegenius.feature.aluno.course.model.ModuleModel
import com.example.codegenius.feature.aluno.course.sampleData.contentModuleMock

@Composable
fun ModuleContentList(
    title: String,
    modifier: Modifier = Modifier,
    moduleModel: ModuleModel //TODO
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
        Column {
            val sortedLessons = moduleModel.moduleLessonModel.sortedBy { it.lessonOrder }
            sortedLessons.forEachIndexed { index, moduleLesson ->
                ModuleContent(moduleLessonModel = moduleLesson, order = moduleModel.moduleOrder)

                if (index < moduleModel.moduleLessonModel.size - 1) {
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ModuleContentListPreview() {
    ModuleContentList(
        title = "Modulo",
        moduleModel = contentModuleMock.get(0)
    )
}