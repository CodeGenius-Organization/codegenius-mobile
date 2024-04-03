package com.example.codegenius.feature.aluno.course.view.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codegenius.R
import com.example.codegenius.feature.aluno.course.view.ui.theme.pinkGenius
import com.example.codegenius.feature.aluno.course.view.ui.theme.purpleGenius

@Composable
fun CourseContent(
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        shadowElevation = 4.dp,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .heightIn(250.dp, 300.dp)
                .width(200.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            pinkGenius , purpleGenius
                        )
                    )
                )
        ) {
            Box(
                modifier = Modifier
                    .height(130.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(R.drawable.mask_group),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Image(
                    painter = painterResource(R.drawable.mask_group),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier.padding(14.dp)
            ) {
                Text(
                    text = "Lógica de Programação",
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(700),
                )
                Text(
                    text = "Java",
                    color = Color.White,
                    style = MaterialTheme.typography.labelMedium,
                    fontSize = 10.sp,
                    fontWeight = FontWeight(400)
                )
                Row {
                    Text(
                        text = stringResource(R.string.course_content_label),
                        color = Color.White,
                        style = MaterialTheme.typography.labelMedium,
                        fontSize = 10.sp,
                        fontWeight = FontWeight(700)
                    )
                    Text(
                        modifier = Modifier.padding(start = 3.dp),
                        text = "Helena Pêra",
                        color = Color.White,
                        style = MaterialTheme.typography.labelMedium,
                        fontSize = 10.sp,
                        fontWeight = FontWeight(400)
                    )
                }
                Text(
                    text = "Em andamento",
                    color = Color.White,
                    style = MaterialTheme.typography.labelMedium,
                    fontSize = 10.sp,
                    fontWeight = FontWeight(400)
                )
                Row {
                    Image(
                        modifier = Modifier
                            .width(70.dp)
                            .height(16.dp)
                            .padding(end = 3.dp),
                        painter = painterResource(R.drawable.stars),
                        contentDescription = null
                    )
                    Text(
                        text = "4.0 (1963)",
                        color = Color.White,
                        style = MaterialTheme.typography.labelMedium,
                        fontSize = 10.sp,
                        fontWeight = FontWeight(700)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CourseContentPreview() {
    CourseContent()
}