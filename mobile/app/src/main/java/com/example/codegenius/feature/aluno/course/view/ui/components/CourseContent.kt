package com.example.codegenius.feature.aluno.course.view.ui.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import com.example.codegenius.feature.aluno.course.model.CourseModel
import com.example.codegenius.feature.aluno.course.sampleData.contentCoursesMock
import com.example.codegenius.feature.aluno.shared.ui.theme.pinkGenius
import com.example.codegenius.feature.aluno.shared.ui.theme.purpleGenius
import com.example.codegenius.feature.aluno.shared.util.singleton.Util

@Composable
fun CourseContent(
    modifier: Modifier = Modifier,
    courseModel: CourseModel,
    onNavigateToLesson : () -> Unit = {}
) {

    val nomes = listOf("Ana Amelia", "Bruno Benjamin", "Carlos Costa", "Daniela Dias", "Eduardo Edgar", "Fernanda Ferreira", "Gabriel Guedes", "Helena Hwak", "Juliana Jordan")
    val nomeAleatorio = remember { nomes[gerarIndiceAleatorio(nomes.size)] }
    val score = remember {
        gerarNumeroAleatorio(1,5)
    }
    val scoreDecimal = remember {
        gerarNumeroAleatorio(0,9)
    }
    val avaliations = remember {
        gerarNumeroAleatorio(0,2000)
    }

    Surface(
        shape = RoundedCornerShape(8.dp),
        shadowElevation = 4.dp,
        modifier = modifier,
        onClick = {
            Util.getInstance().courseId = courseModel.id
            Log.d("##Click",courseModel.toString())
            onNavigateToLesson() }
    ) {
        Column(
            modifier = Modifier
                .heightIn(250.dp, 300.dp)
                .width(200.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            pinkGenius, purpleGenius
                        )
                    )
                ),
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
            }
            Column(
                modifier = Modifier.padding(14.dp)
            ) {
                Text(
                    text = courseModel.title,
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(700),
                )
                LazyRow {
                    items(courseModel.languages.toList()) { languages ->
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(3.dp)
                        ){
                            Text(
                                text = languages.language,
                                color = Color.White,
                                style = MaterialTheme.typography.labelMedium,
                                fontSize = 10.sp,
                                fontWeight = FontWeight(400)
                            )

                            if (courseModel.languages.indexOf(languages) < courseModel.languages.size - 1) {
                                Text(
                                    text = "•",
                                    modifier = Modifier.padding(end = 3.dp),
                                    color = Color.White,
                                    style = MaterialTheme.typography.labelMedium,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight(400),
                                )
                            }
                        }
                    }
                }
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
                        text = nomeAleatorio,
                        color = Color.White,
                        style = MaterialTheme.typography.labelMedium,
                        fontSize = 10.sp,
                        fontWeight = FontWeight(400)
                    )
                }
                Text(
                    text = "Não Iniciado",
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
                        text = "${score}.${if(score == 5) 0 else scoreDecimal} (${avaliations})",
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

private fun gerarIndiceAleatorio(tamanho: Int): Int {
    return (0 until tamanho).random()
}

private fun gerarNumeroAleatorio(min: Int, max: Int): Int {
    return (min..max).random()
}

@Preview
@Composable
fun CourseContentPreview() {
    CourseContent(
        courseModel =  contentCoursesMock.get(0)
    )
}