package com.example.di_ejercicio_lazycolumn_scaffold

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ItemJuego(juego: Juego, onItemSelected: (Juego) -> Unit) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 16.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { onItemSelected(juego) }) {
        Column {
            Image(
                painter = painterResource(id = juego.portada),
                contentDescription = null,
                modifier = Modifier.fillMaxSize().padding(3.dp)
            )
            Text(
                text = juego.nombre, textAlign = TextAlign.Center, maxLines = 1,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}