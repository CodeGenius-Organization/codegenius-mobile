package com.example.codegenius.feature.aluno.shared.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codegenius.R

@Composable
fun NavigationbarCourse(
    modifier: Modifier = Modifier,
    content : Boolean = false,
    exercise : Boolean = false,
    test: Boolean = false,
    onNagivationLessonContent : () ->  Unit = {},
    onNavigationLessonExercise : () -> Unit = {},
    onNavigationLessonTest: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        IconButton(
            modifier = Modifier.width(150.dp),
            onClick = { onNagivationLessonContent() }
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.padding(end = 6.dp),
                        painter = painterResource(R.drawable.content_icon),
                        contentDescription = null
                    )
                    Text(
                        text = stringResource(R.string.course_navigationbar_content),
                        color = Color.White,
                        fontWeight = FontWeight(400)
                    )
                }
                if (content) {
                    HorizontalDivider(
                        modifier = Modifier
                            .height(3.dp),
                        color = Color(0xFFD868FF)
                    )
                }
            }
        }
        IconButton(
            modifier = Modifier.width(150.dp),
            onClick = { onNavigationLessonExercise() }
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.padding(end = 6.dp),
                        painter = painterResource(R.drawable.exercise_icon),
                        contentDescription = null
                    )
                    Text(
                        text = stringResource(R.string.course_navigationbar_exercise),
                        color = Color.White,
                        fontWeight = FontWeight(400)
                    )
                }
                if (exercise) {
                    HorizontalDivider(
                        modifier = Modifier
                            .height(3.dp),
                        color = Color(0xFFD868FF)
                    )
                }
            }
        }
        IconButton(
            modifier = Modifier.width(150.dp),
            onClick = { onNavigationLessonTest() }
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.padding(end = 6.dp),
                        painter = painterResource(R.drawable.test_icon),
                        contentDescription = null
                    )
                    Text(
                        text = stringResource(R.string.course_navigationbar_test),
                        color = Color.White,
                        fontWeight = FontWeight(400)
                    )
                }
                if (test) {
                    HorizontalDivider(
                        modifier = Modifier
                            .height(3.dp),
                        color = Color(0xFFD868FF)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun NavigationvarCoursePreview() {
    NavigationbarCourse()
}