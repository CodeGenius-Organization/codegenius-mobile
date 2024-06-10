package com.example.codegenius.feature.aluno.course.view.ui.components

import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.codegenius.R
import com.example.codegenius.feature.aluno.course.model.LessonContentModel
import com.example.codegenius.feature.aluno.course.sampleData.contentModuleMock

@Composable
fun ModuleDescription(
    lessonContentModel: LessonContentModel,
    modifier: Modifier = Modifier
) {
    Column {
        Text(
            text = lessonContentModel.title,
            modifier = Modifier
                .padding(
                    start = 16.dp, end = 16.dp, bottom = 25.dp
                )
                .fillMaxWidth(),
            color = Color.White,
            fontSize = 23.sp,
            fontWeight = FontWeight(400)
        )
        Text(
            text = lessonContentModel.content,
            modifier = Modifier
                .padding(
                    start = 16.dp, end = 16.dp, bottom = 25.dp
                )
                .fillMaxWidth(),
            color = Color.White,
            fontSize = 16.sp
        )
    }
}

//@Preview
//@Composable
//fun ModuleDescriptionPreview() {
//    ModuleDescription(
//        lessonContentModel = contentModuleMock.get(0)
//            .lessons.get(0)
//            .lessonContent
//    )
//}