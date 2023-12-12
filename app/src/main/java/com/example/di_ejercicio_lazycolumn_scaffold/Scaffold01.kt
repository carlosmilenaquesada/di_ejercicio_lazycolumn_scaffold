package com.example.di_ejercicio_lazycolumn_scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Scaffold01() {
    Scaffold() { contentPadding ->
        Box(
            modifier = Modifier
                .padding(contentPadding)
                .height(50.dp)
                .background(Color.Cyan)
        ) {

        }
    }
}