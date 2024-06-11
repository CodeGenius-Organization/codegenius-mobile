package com.example.codegenius.feature.aluno.course.view.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.codegenius.R
import com.example.codegenius.feature.aluno.shared.ui.theme.blueDarkGenius
import com.example.codegenius.feature.aluno.shared.ui.theme.blueGenius

@Composable
fun ModalFeedback (
    onClose : () -> Unit = {},
    onConfirm : () -> Unit = {}
) {
    Dialog(
    onDismissRequest = { onClose() }) {
        Surface(
            shape = RoundedCornerShape(8.dp),
            shadowElevation = 4.dp
        ) {
            var rating by remember { mutableStateOf(0) }
            var feedbackText by remember { mutableStateOf("") }

            Box(
                modifier = Modifier
                    .height(520.dp)
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    Row(
                        modifier = Modifier
                            .height(56.dp)
                            .fillMaxWidth()
                            .background(
                                brush = Brush.linearGradient(
                                    colors = listOf(
                                        blueDarkGenius, blueGenius
                                    )
                                )
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(15.dp)
                                .weight(1f),
                            color = Color.White,
                            text = "FEEDBACK DO CURSO"
                        )
                        IconButton(
                            onClick = { onClose() }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Close,
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = Modifier.padding(20.dp),
                            color = blueDarkGenius,
                            text = "UHUU! Você concluiu este curso!",
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                        Image(
                            modifier = Modifier.padding(20.dp),
                            painter = painterResource(R.drawable.rewarded_adsteste),
                            contentDescription = null
                        )
                        Text(
                            color = blueDarkGenius,
                            text = "Nos dê sua opinião sobre o curso:",
                            textAlign = TextAlign.Center
                        )
                        RatingBar(
                            rating = rating,
                            onRatingChanged = { newRating ->
                                rating = newRating
                            }
                        )
                        OutlinedTextField(
                            value = feedbackText,
                            onValueChange = { newText ->
                                feedbackText = newText
                            },
                            label = { Text("Opcional") },
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(100.dp),
                            maxLines = 100
                        )
                        Row(
                            modifier = Modifier.padding(top = 20.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Button(
                                modifier = Modifier
                                    .width(170.dp)
                                    .padding(horizontal = 15.dp),
                                shape = RoundedCornerShape(8.dp),
                                colors = ButtonDefaults.buttonColors(
                                    Color.Red
                                ),
                                onClick = { onClose() }
                            ) {
                                Text(
                                    text = "Agora não",
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Button(
                                modifier = Modifier
                                    .width(120.dp)
                                    .padding(end = 15.dp),
                                shape = RoundedCornerShape(8.dp),
                                colors = ButtonDefaults.buttonColors(
                                    blueDarkGenius
                                ),
                                onClick = { onConfirm() }
                            ) {
                                Text(
                                    text = "Enviar",
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RatingBar(
    rating: Int,
    onRatingChanged: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        for (i in 1..5) {
            val starIcon = if (i <= rating) {
                Icons.Filled.Star
            } else {
                Icons.Filled.StarBorder
            }

            Icon(
                imageVector = starIcon,
                contentDescription = null,
                modifier = Modifier
                    .padding(4.dp)
                    .clickable {
                        onRatingChanged(i)
                    },
                tint = if (i <= rating) Color(0xFFF4CC3B) else Color(0xFF242C50)
            )
        }
    }
}

@Preview
@Composable
fun ModalFeedbackPreview() {
    ModalFeedback()
}