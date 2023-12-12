package com.example.di_ejercicio_lazycolumn_scaffold

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FloatingActionButton01() {
    SmallFloatingActionButton(
        onClick = {},
        containerColor = Color(0xFFBB86FC),
        shape = RoundedCornerShape(2.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = null,
            tint = Color(0xFF3700B3)
        )
    }

}