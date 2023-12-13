package com.example.di_ejercicio_lazycolumn_scaffold

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar01(
    onClickIcon: (String) -> Unit,
    onClickDrawer: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = "Catálogo de juegos", color = Color(0xFFBB86FC))
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color(0xFF3700B3),
        ),
        navigationIcon = {
            IconButton(onClick = { onClickDrawer() }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu",
                    tint = Color(0xFFBB86FC)
                )
            }
        },
        actions = {
            var notificacionActiva by rememberSaveable {
                mutableStateOf(false)
            }
            IconButton(onClick = {
                notificacionActiva = !notificacionActiva
                onClickIcon(
                    if (notificacionActiva) {
                        "Notificaciones activadas"
                    } else {
                        "Notificaciones desactivadas"
                    }
                )
            }) {
                Icon(
                    imageVector = Icons.Filled.Notifications, contentDescription = "Notification",
                    tint = if (notificacionActiva) {
                        Color.Red
                    } else {
                        Color(0xFFBB86FC)
                    }
                )
            }
            val activity = (LocalContext.current as? Activity)
            IconButton(onClick = {
                onClickIcon("Hasta pronto")
                activity?.finish()
            }) {
                Icon(
                    imageVector = Icons.Filled.Close, contentDescription = "Close",
                    tint = Color(0xFFBB86FC)
                )
            }
        }

    )

}


















