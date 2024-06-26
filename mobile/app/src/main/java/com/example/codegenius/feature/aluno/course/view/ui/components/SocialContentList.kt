package com.example.codegenius.feature.aluno.course.view.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codegenius.feature.aluno.course.model.UserModel
import com.example.codegenius.feature.aluno.course.sampleData.socialUsersMock
import com.example.codegenius.feature.aluno.shared.ui.theme.CardSocialTheme

@Composable
fun SocialContentList(
    user: List<UserModel>
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(user) {user ->
            SocialContent(
                image = user.image,
                name = user.name,
                following = user.following)
        }
    }
}

@Preview(showBackground = false, widthDp = 274)
@Composable
fun SocialContentListPreview() {
    CardSocialTheme {
        SocialContentList(socialUsersMock)
    }
}