package com.example.di_ejercicio_lazycolumn_scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog


@Composable
fun MostrarDialogPersonalizado() {
    var show by rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Ejemplo Dialog")
        Spacer(Modifier.height(16.dp))
        Button(onClick = { show = true }, shape = RoundedCornerShape(5.dp)) {
            Text(text = "Acceso usuario")
        }
    }

    DialogPersonalizado(show = show, onDismiss = { show = false })
}

@Composable
fun DialogPersonalizado(
    show: Boolean,
    onDismiss: () -> Unit
) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .background(Color(0xFF004166))
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                ContenidoDialogPersonalizado(onDismiss)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContenidoDialogPersonalizado(onDismiss: () -> Unit) {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
        Icon(imageVector = Icons.Default.Close,
            contentDescription = "Close app",
            modifier = Modifier
                .clickable { onDismiss() }
        )
    }/*

    var usuario by rememberSaveable {
        mutableStateOf("")
    }
    var contrasenia by rememberSaveable {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = usuario,
        onValueChange = { usuario = it },
        label = { Text(text = "Usuario", color = Color.White) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.White,
            unfocusedBorderColor = Color.White
        ), textStyle = TextStyle(color = Color.White)
    )
    Spacer(Modifier.height(16.dp))
    OutlinedTextField(
        value = contrasenia,
        onValueChange = { contrasenia = it },
        label = { Text(text = "Usuario", color = Color.White) },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.White,
            unfocusedBorderColor = Color.White
        ), textStyle = TextStyle(color = Color.White)
    )
    Spacer(Modifier.height(16.dp))
    var showMostrarDatos by rememberSaveable {
        mutableStateOf(false)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxWidth()
    ) {


        Button(onClick = {
            showMostrarDatos = true

        }
        ) {
            Text(text = "Aceptar")
        }

        Button(onClick = { onDismiss() }) {
            Text(text = "Cancelar")
        }

    }
    MostrarDatos(onDismiss, showMostrarDatos, usuario)*/
}

@Composable
fun MostrarDatos(
    onDismiss: () -> Unit,
    showMostrarDatos: Boolean,
    usuario: String
) {
    if (showMostrarDatos) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Card(
                modifier = Modifier.border(1.dp, Color.Black, RoundedCornerShape(5)),
                shape = RoundedCornerShape(5)
            ) {
                Column(
                    Modifier
                        .background(Color(0xFF4599B5))
                ) {
                    Text(
                        text = "Bienvenido",
                        fontStyle = FontStyle.Italic,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.White

                    )
                    Text(
                        text = usuario, fontSize = 24.sp, textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "La contraseña ha sido aceptada",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

            }

        }

    }

}