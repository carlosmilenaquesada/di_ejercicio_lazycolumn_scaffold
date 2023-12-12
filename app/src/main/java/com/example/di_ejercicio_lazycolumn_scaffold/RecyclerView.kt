package com.example.di_ejercicio_lazycolumn_scaffold


import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

@Composable
fun RecyclerView(plataformaElegida: String) {
    val context = LocalContext.current
    LazyVerticalGrid(columns = GridCells.Fixed(3), Modifier.background(Color(0xFF6200EE)))
    {
        items(getJuegos()) {

            ItemJuego(juego = it) {
                Toast.makeText(context, it.toString(), Toast.LENGTH_LONG).show()
            }


        }
    }


}
