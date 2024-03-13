package com.example.mobile_tela_login_codegenius

import android.os.Bundle
import android.text.Layout
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobile_tela_login_codegenius.ui.theme.MobiletelalogincodegeniusTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobiletelalogincodegeniusTheme {
                appPreview()
            }
        }
    }
}

@Composable
fun App(
    @DrawableRes imagem: Int
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(red = 12, green = 15, blue = 26))

    ) {
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height(200.dp)
        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                painter = painterResource(
                    id = R.drawable.logo_1),
                contentDescription = null
            )

            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 8.dp),
                text = "CodeGenius",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White,
                fontWeight = FontWeight.Light,
                fontSize = 18.sp,
            )
        }
    }

    var email by remember {
        mutableStateOf("")
    }

    Column (
        modifier = Modifier
    ){

        Text(
            modifier = Modifier.padding(top = 200.dp, start = 30.dp),
            text = "Olá novamente!",
            style = MaterialTheme.typography.titleMedium,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Light
        )

        Text(
            modifier = Modifier.padding(top = 40.dp, start = 30.dp),
            text = "E-mail",
            style = MaterialTheme.typography.titleMedium,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Light
        )

        OutlinedTextField(
            modifier = Modifier
                .width(360.dp)
                .padding(start = 30.dp, top = 8.dp)
                .background(
                    Color.Transparent,
                    RoundedCornerShape(20.dp)
                ),
            value = email,
            onValueChange = {
                email = it
            },
            placeholder = {
                Text(
                    "Digite seu e-mail"
                )
            }
        )

        Text(
            modifier = Modifier.padding(top = 40.dp, start = 30.dp),
            text = "Senha",
            style = MaterialTheme.typography.titleMedium,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Light
        )

        OutlinedTextField(
            modifier = Modifier
                .width(360.dp)
                .padding(start = 30.dp, top = 8.dp),
                    value = email,
            onValueChange = {
                email = it
            },
            placeholder = {
                Text(
                    "Digite seu e-mail"
                )
            }
        )

        Text(
            modifier = Modifier.padding(top = 40.dp, start = 200.dp),
            text = "Esqueceu sua senha?",
            style = MaterialTheme.typography.displaySmall,
            color = Color.White,
            fontSize = 15.sp,
            fontWeight = FontWeight.Light
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.CenterHorizontally)
                .padding(20.dp),
            onClick = { /*TODO*/ }) {

            Text(text = "ENTRAR")
        }

        Text(
            modifier = Modifier.padding(start = 65.dp),
            text = "Não possui uma conta?Cadastre-se aqui",
            color = Color.White,
            fontSize = 15.sp,
            fontWeight = FontWeight.Light
        )
    }


}


@Preview(showBackground = true)
@Composable
fun appPreview(){
    App(R.drawable.logo_1)
}
