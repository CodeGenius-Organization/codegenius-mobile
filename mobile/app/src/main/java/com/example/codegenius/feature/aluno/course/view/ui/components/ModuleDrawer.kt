package com.example.codegenius.feature.aluno.course.view.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codegenius.feature.aluno.course.model.ModuleModel
import com.example.codegenius.feature.aluno.course.sampleData.contentModuleMock

@Composable
fun ModuleDrawer(
    modifier: Modifier = Modifier,
    moduleModel: List<ModuleModel>,
    onNavigationLessonContent : () -> Unit = {}
) {
    ModalDrawerSheet (
        modifier = modifier
    ) {
        LazyColumn(
            Modifier.fillMaxSize().background(Color(red = 12, green = 15, blue = 26)).padding(vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(moduleModel.sortedBy { it.moduleOrder }) { module ->
                ModuleContentList(
                    title = module.moduleName,
                    moduleModel = module,
                    onNavigationLessonContent = onNavigationLessonContent
                )
            }
        }
    }
}

//@Preview()
//@Composable
//fun ModuleDrawerPreview() {
//    ModuleDrawer(moduleModel = contentModuleMock)
//}