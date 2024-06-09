package com.example.codegenius.feature.aluno.course.view.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.codegenius.R
import com.example.codegenius.feature.aluno.shared.ui.theme.blueDarkGenius
import com.example.codegenius.feature.aluno.shared.ui.theme.blueGenius

@Composable
fun ModalConfirmacao(
    onClose : () -> Unit = {},
    onConfirm : () -> Unit = {}
) {
    Dialog(onDismissRequest = { onClose() }) {
        Surface(
            shape = RoundedCornerShape(8.dp),
            shadowElevation = 4.dp
        ) {
            Box(
                modifier = Modifier
                    .height(456.dp)
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
                            text = stringResource(R.string.modal_conclued)
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
                        Image(
                            modifier = Modifier.padding(56.dp),
                            painter = painterResource(R.drawable.check_circle),
                            contentDescription = null
                        )
                        Text(
                            modifier = Modifier.padding(10.dp),
                            color = blueDarkGenius,
                            text = stringResource(R.string.modal_conclued_title),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            color = blueDarkGenius,
                            text = stringResource(R.string.modal_conclued_subtitle)
                        )
                        HorizontalDivider(
                            modifier = Modifier.padding(
                                start = 15.dp,
                                end = 15.dp,
                                bottom = 15.dp,
                                top = 100.dp
                            )
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
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
                                    text = stringResource(R.string.modal_conclued_button_close),
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
                                    text = stringResource(R.string.modal_conclued_button_confirm),
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

@Preview
@Composable
fun ModalConfrimacaoPreview() {
    ModalConfirmacao()
}