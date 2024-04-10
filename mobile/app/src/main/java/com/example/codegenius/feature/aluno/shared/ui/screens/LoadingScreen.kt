package com.example.codegenius.feature.aluno.shared.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codegenius.R
import com.example.codegenius.feature.aluno.shared.ui.components.CorporativeInsignia
import com.example.codegenius.feature.aluno.shared.ui.theme.BackgroundGenius

@Composable
fun SplashScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundGenius),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CorporativeInsignia()
        Image(
            modifier = Modifier
            .size(50.dp)
            .padding(top = 10.dp),
            painter = painterResource(id = R.drawable.loading_1),
            contentDescription = null
        )
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}