package com.example.codegenius.feature.aluno.login.view.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegisterBox() {
    var teste by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .padding(horizontal = 30.dp)
    ) {

        Text(
            text = "Olá!",
            style = MaterialTheme.typography.titleMedium,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Light
        )

        Text(
            modifier = Modifier.padding(top = 40.dp),
            text = "Nome:",
            style = MaterialTheme.typography.titleMedium,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Light
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .background(
                    Color.Transparent
                ),
            value = teste,
            onValueChange = {
                teste = it
            },
            shape = RoundedCornerShape(100),
            placeholder = {
                Text(
                    "Digite seu nome"
                )
            }
        )

        Text(
            modifier = Modifier.padding(top = 40.dp),
            text = "Sobrenome:",
            style = MaterialTheme.typography.titleMedium,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Light
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .background(
                    Color.Transparent
                ),
            value = teste,
            onValueChange = {
                teste = it
            },
            shape = RoundedCornerShape(100),
            placeholder = {
                Text(
                    "Digite seu sobrenome"
                )
            }
        )

        Text(
            modifier = Modifier.padding(top = 40.dp),
            text = "E-mail:",
            style = MaterialTheme.typography.titleMedium,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Light
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .background(
                    Color.Transparent
                ),
            value = teste,
            onValueChange = {
                teste = it
            },
            shape = RoundedCornerShape(100),
            placeholder = {
                Text(
                    "Digite seu e-mail"
                )
            }
        )

        Text(
            modifier = Modifier.padding(top = 40.dp),
            text = "Senha:",
            style = MaterialTheme.typography.titleMedium,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Light
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .background(
                    Color.Transparent
                ),
            value = teste,
            onValueChange = {
                teste = it
            },
            shape = RoundedCornerShape(100),
            placeholder = {
                Text(
                    "Digite sua senha"
                )
            }
        )

        Text(
            modifier = Modifier.padding(top = 40.dp),
            text = "Confirmação de senha:",
            style = MaterialTheme.typography.titleMedium,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Light
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .background(
                    Color.Transparent
                ),
            value = teste,
            onValueChange = {
                teste = it
            },
            shape = RoundedCornerShape(100),
            placeholder = {
                Text(
                    "Digite sua senha"
                )
            }
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.CenterHorizontally)
                .padding(top = 60.dp, bottom = 20.dp),
            onClick = { /*TODO*/ }) {

            Text(text = "CADASTRAR")
        }

        Text(
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(bottom = 20.dp),
            text = "Já tem cadastro? Entre aqui",
            color = Color.White,
            fontSize = 15.sp,
            fontWeight = FontWeight.Light
        )

    }
}

@Preview()
@Composable
fun RegisterBoxPreview() {
    RegisterBox()
}