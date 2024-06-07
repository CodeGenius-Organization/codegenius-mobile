package com.example.codegenius.feature.aluno.shared.ui.components

import android.util.Log
import android.util.MutableBoolean
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Login
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Security
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codegenius.R
import com.example.codegenius.feature.aluno.shared.ui.theme.BackgroundGenius

@Composable
fun Navigationbar(
    modifier: Modifier = Modifier,
    onLogout: () -> Unit
) {
    var showDialog by remember{
       mutableStateOf(false)
    }
    Row (
        modifier = modifier
            .fillMaxWidth()
            .background(BackgroundGenius)
            .padding(vertical = 15.dp, horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CorporativeInsignia()
        IconButton(
            onClick = { showDialog = true },
        ) {
            Icon(
                imageVector = Icons.Filled.Logout,
                contentDescription = null,
                tint = Color.White
            )
        }
    }

    if (showDialog) {
        AlertDialog(
            icon = {
                Icon(
                    modifier = Modifier.size(45.dp),
                    imageVector = Icons.Filled.Logout,
                    contentDescription = "Icone de Logout"
                )
            },
            title = {
                Text(
                    text = stringResource(R.string.modal_logout_title),
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight(700),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            },
            text = {
                    Text(
                        text = stringResource(R.string.modal_logout_body),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight(400),
                        overflow = TextOverflow.Ellipsis
                    )
            },
            onDismissRequest = {
                showDialog = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showDialog = false
                        onLogout()
                    }
                ) {
                    Text(
                        text = stringResource(R.string.dialog_button_accept),
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(700),
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {  showDialog = false }
                ) {
                    Text(
                        text = stringResource(R.string.dialog_button_dismiss),
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(700),
                    )
                }
            }
        )
    }
}

//@Preview
//@Composable
//fun NavigationbarPreview() {
//    Navigationbar()
//}