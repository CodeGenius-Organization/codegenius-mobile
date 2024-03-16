package com.example.codegenius.feature.aluno.shared.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codegenius.R
import com.example.codegenius.feature.aluno.shared.ui.components.CorporativeInsignia

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(red = 12, green = 15, blue = 26)),
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        ) {
            CorporativeInsignia()
        }
        Image(
            modifier = Modifier
                .size(33.dp)
                .padding(top = 12.dp)
                .align(alignment = Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.loading_1),
            contentDescription = null
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoadingScreenPreview() {
    LoadingScreen()
}