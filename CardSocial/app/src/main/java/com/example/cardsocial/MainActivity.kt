package com.example.cardsocial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cardsocial.ui.theme.CardSocialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardSocialTheme {
                // A surface container using the 'background' color from the theme
                Surface() {

                }
            }
        }
    }
}

data class User(
    val id: Int,
    val image: Int,
    val name: String,
    val following: Boolean
)

val socialUsersMock = listOf(
    User(
        id = 1,
        image = R.drawable.social_image,
        name = "Paula Maria",
        following = true),
    User(
        id = 1,
        image = R.drawable.social_image,
        name = "Maria Paula",
        following = false),
    User(
        id = 1,
        image = R.drawable.social_image,
        name = "Maria Paula",
        following = true)
)

@Composable
fun SocialContentList() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(socialUsersMock) {user ->
            SocialContent(
                image = user.image,
                name = user.name,
                following = user.following)
        }
    }
}

@Composable
fun SocialContent(
    @DrawableRes image: Int,
    name: String,
    following: Boolean
) {
    Column(
        horizontalAlignment =
        Alignment.CenterHorizontally,
        modifier = Modifier
            .border(border = BorderStroke(1.dp, Color.White))
            .padding(horizontal = 8.dp, vertical = 16.dp)
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .background(Color.Magenta)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = name,
            color = Color.White,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* Ação a ser executada quando o botão for clicado */ },
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.White
            ),
            border = BorderStroke(1.dp, Color.White),
            modifier = Modifier
                .widthIn(min = 120.dp)
        ) {
            val buttonText = if (following) {
                "Deixar de seguir"
            } else {
                "Seguir"
            }
            Text(

                text = buttonText,
                style = MaterialTheme.typography.bodySmall,
                fontSize = 10.sp
            )

        }
    }
}

@Preview(showBackground = false)
@Composable
fun SocialContentPreview() {
    CardSocialTheme {
        SocialContent(
            R.drawable.social_image,
            "Mariana Namie",
            true
        )
    }
}

@Preview(showBackground = false, widthDp = 274)
@Composable
fun SocialContentListPreview() {
    CardSocialTheme {
        SocialContentList()
    }
}