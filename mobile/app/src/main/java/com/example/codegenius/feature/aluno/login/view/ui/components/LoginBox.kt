package com.example.codegenius.feature.aluno.login.view.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
<<<<<<< HEAD
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
=======
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
>>>>>>> c10111ba234163742c94d0248298d56702702415
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
<<<<<<< HEAD
=======
import androidx.compose.ui.text.SpanStyle
>>>>>>> c10111ba234163742c94d0248298d56702702415
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codegenius.R

@Composable
fun LoginBox(
<<<<<<< HEAD
=======
    modifier: Modifier = Modifier,
    onNavigateToRegister: () -> Unit = {}
>>>>>>> c10111ba234163742c94d0248298d56702702415
) {
    var teste by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .padding(horizontal = 30.dp)
    ) {
        Text(
            modifier = Modifier.padding(bottom = 32.dp),
            text = stringResource(R.string.login_label_welcome),
            style = MaterialTheme.typography.titleMedium,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Light
        )
<<<<<<< HEAD
=======

        Text(
            modifier = Modifier.padding(top = 40.dp),
            text = stringResource(R.string.login_label_email),
            style = MaterialTheme.typography.titleMedium,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Light
        )

>>>>>>> c10111ba234163742c94d0248298d56702702415
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
                .background(
                    Color.Transparent
                ),
            label = {
                Text(
                    text = stringResource(R.string.login_label_email),
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light
                )
            },
            value = teste,
            onValueChange = {
                teste = it
            },
            shape = RoundedCornerShape(20),
            placeholder = {
                Text(
                    stringResource(R.string.login_placeholder_password)
                )
            },
            textStyle = TextStyle(Color.White)
        )

        OutlinedTextField(
            modifier = Modifier
                .width(360.dp)
                .padding(bottom = 12.dp),
            value = teste,
            onValueChange = {
                teste = it
            },
            label = {
                Text(
                    text = stringResource(R.string.login_label_password),
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light
                )
            },
            shape = RoundedCornerShape(20),
            placeholder = {
                Text(
                    stringResource(R.string.login_placeholder_password)
                )
            }
        )

        ClickableText(
            modifier = Modifier
<<<<<<< HEAD
                .align(alignment = Alignment.End)
                .padding(bottom = 50.dp),
            text = stringResource(R.string.login_link_forgot_password),
            style = MaterialTheme.typography.displaySmall,
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Light
=======
                .padding(top = 20.dp)
                .align(alignment = Alignment.End),
            text = AnnotatedString(stringResource(R.string.login_link_forgot_password)),
            style = TextStyle(color = Color.White),
            onClick = { /*TODO*/ }
>>>>>>> c10111ba234163742c94d0248298d56702702415
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.CenterHorizontally)
                .padding(bottom = 11.dp),
            onClick = { /*TODO*/ }) {

            Text(text = stringResource(R.string.login_button))
        }

        ClickableText(
            modifier = Modifier
<<<<<<< HEAD
                .align(alignment = Alignment.CenterHorizontally),
            text = AnnotatedString(stringResource(R.string.login_link_register)),
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Light,
                color = Color.White
            ),
            onClick = {
=======
                .align(alignment = Alignment.CenterHorizontally)
                .padding(bottom = 20.dp),
            text = AnnotatedString(stringResource(R.string.login_link_register)),
            style = TextStyle(color = Color.White),
            onClick = {
                onNavigateToRegister()
>>>>>>> c10111ba234163742c94d0248298d56702702415
            }
        )
    }
}

@Preview
@Composable
fun LoginBoxPreview() {
    LoginBox()
}