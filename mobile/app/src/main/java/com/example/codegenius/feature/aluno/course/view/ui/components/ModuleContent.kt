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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codegenius.feature.aluno.course.model.ModuleModel

@Composable
fun ModuleContent(
    modifier: Modifier = Modifier,
    moduleModel: ModuleModel? = null //TODO
) {
    Column(
        modifier = modifier
            .padding(vertical = 10.dp)
            .padding(
                start = 16.dp, end = 16.dp
            )
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(bottom = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = "1-1",
                color = Color.White
            )
            Text(
                text = "Parte 1",
                color = Color.White
            )
        }
        Text(
            text = "Consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            color = Color.White
        )
    }
}

@Preview
@Composable
fun ModuleContentPreview() {
    ModuleContent()
}