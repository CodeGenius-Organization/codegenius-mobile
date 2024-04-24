package com.example.codegenius.feature.aluno.course.view.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codegenius.feature.aluno.course.model.ModuleLessonModel
import com.example.codegenius.feature.aluno.course.model.ModuleModel
import com.example.codegenius.feature.aluno.course.sampleData.contentModuleMock
import java.util.UUID

@Composable
fun ModuleContent(
    modifier: Modifier = Modifier,
    order: Int,
    moduleLessonModel: ModuleLessonModel //TODO
) {
    Column(
        modifier = modifier
            .padding(vertical = 16.dp)
            .padding(
                start = 16.dp, end = 16.dp
            )
            .fillMaxWidth()
    ) {
        LessonContent(lesson = moduleLessonModel, order = order)
    }
}

@Composable
fun LessonContent(lesson: ModuleLessonModel, order: Int) {
    Column {
        Row(
            modifier = Modifier.padding(bottom = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = "${order}-${lesson.lessonOrder}",
                color = Color.White
            )
            Text(
                text = lesson.lessonTitle,
                color = Color.White
            )
        }
        Text(
            text = lesson.contentDescription,
            color = Color.White
        )
    }
}

@Preview
@Composable
fun ModuleContentPreview() {
    ModuleContent(
        order = 1,
        moduleLessonModel = contentModuleMock.get(0).moduleLessonModel.get(0)
    )
}