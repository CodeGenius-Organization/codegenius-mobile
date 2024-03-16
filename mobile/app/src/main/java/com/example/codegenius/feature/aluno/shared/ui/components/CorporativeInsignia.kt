package com.example.codegenius.feature.aluno.shared.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codegenius.R

@Composable
fun CorporativeInsignia(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row {
            Image(
                modifier = Modifier
                    .align(alignment = Alignment.CenterVertically)
                    .size(33.dp),
                painter = painterResource(
                    id = R.drawable.logo_1),
                contentDescription = null
            )

            Column(
                modifier = Modifier.padding(start = 6.dp)
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 8.dp),
                    text = "CodeGenius",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontSize = 18.sp,
                )

                Text(
                    modifier = Modifier
                        .padding(start = 8.dp),
                    text = "VERSION 1.0",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp,
                )
            }
        }
    }
}

@Preview()
@Composable
fun CorporativeInsigniaPreview() {
    CorporativeInsignia()
}