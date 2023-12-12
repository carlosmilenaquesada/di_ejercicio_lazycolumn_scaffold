package com.example.di_ejercicio_lazycolumn_scaffold

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalDrawer() {
    val snackbarHostState = remember {
        SnackbarHostState()
    }
    val coroutineScope = rememberCoroutineScope()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var plataforma by rememberSaveable {
        mutableStateOf("Todas")
    }
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = false,
        drawerContent = {
            ModalDrawerSheet() {
                NavigationDrawerItem(
                    label = { Text(text = "Todas") },
                    selected = false, onClick = {
                        scope.launch {
                            drawerState.close()
                        }
                        plataforma = "Todas"
                    })
                NavigationDrawerItem(
                    label = { Text(text = "Nintendo Switch") },
                    selected = false, onClick = {
                        scope.launch {
                            drawerState.close()
                        }
                        plataforma = "Nintendo Switch"
                    })
                NavigationDrawerItem(
                    label = { Text(text = "PlayStation 5") },
                    selected = false, onClick = {
                        scope.launch {
                            drawerState.close()
                        }
                        plataforma = "PlayStation 5"
                    })
                NavigationDrawerItem(
                    label = { Text(text = "XBox Series") },
                    selected = false, onClick = {
                        scope.launch {
                            drawerState.close()
                        }
                        plataforma = "XBox Series"
                    })
            }
        }) {

        Scaffold(
            snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
            topBar = {
                TopAppBar01(onClickIcon = {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("$it")
                    }
                }, onClickDrawer = { scope.launch { drawerState.open() } })
            },
            bottomBar = { NavigationBar01() },
            floatingActionButton = { FloatingActionButton01() },
            floatingActionButtonPosition = FabPosition.End
        ) { contentPadding ->
            Box(
                modifier = Modifier
                    .padding(contentPadding)
            ) {
                RecyclerView(plataforma)
            }
        }
    }

}