package com.example.codegenius.feature.aluno.shared.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codegenius.R

@Composable
fun Navigationbar(
    modifier: Modifier = Modifier
) {
    Row (
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CorporativeInsignia()
        Image(
            modifier = Modifier
                .size(33.dp)
                .padding(top = 12.dp),
            painter = painterResource(id = R.drawable.menu),
            contentDescription = null
        )
    }
}

@Preview()
@Composable
fun NavigationbarPreview() {
    Navigationbar()
}