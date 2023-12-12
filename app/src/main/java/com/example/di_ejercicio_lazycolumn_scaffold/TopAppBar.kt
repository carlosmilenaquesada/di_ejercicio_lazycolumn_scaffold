package com.example.di_ejercicio_lazycolumn_scaffold

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch


@Composable
fun ScaffoldTopApp() {


    ModalDrawer()
}

@Composable
fun NavigationBar01() {
    var index by remember {
        mutableStateOf(1)
    }
    NavigationBar(
        containerColor = Color(0xFF3700B3),
        contentColor = Color.White
    ) {
        NavigationBarItem(selected = index == 1, onClick = { index = 1 }, icon = {
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "Account Circle",
                tint = Color(0xFFBB86FC)
            )
        },
            label = { Text(text = "Account") })
        NavigationBarItem(selected = index == 2, onClick = { index = 2 }, icon = {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = "Share",
                tint = Color(0xFFBB86FC)
            )
        },
            label = { Text(text = "Share") })
        NavigationBarItem(selected = index == 3, onClick = { index = 3 }, icon = {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Star",
                tint = Color(0xFFBB86FC)
            )
        },
            label = { Text(text = "Star") })

    }

}

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
            IconButton(onClick = { onClickIcon("Notification") }) {
                Icon(
                    imageVector = Icons.Filled.Notifications, contentDescription = "Notification",
                    tint = Color(0xFFBB86FC)
                )
            }
            IconButton(onClick = { onClickIcon("Close") }) {
                Icon(
                    imageVector = Icons.Filled.Close, contentDescription = "Close",
                    tint = Color(0xFFBB86FC)
                )
            }
        }

    )

}


















