package com.example.di_ejercicio_lazycolumn_scaffold


import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource

@Composable
fun RecyclerView(plataforma: String) {
    val context = LocalContext.current
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        Modifier.background(colorResource(id = R.color.purple_200))
    )
    {
        items(getJuegos(plataforma)) {

            ItemJuego(juego = it) { juego ->
                Toast.makeText(context, juego.toString(), Toast.LENGTH_LONG).show()
            }

        }
    }
}