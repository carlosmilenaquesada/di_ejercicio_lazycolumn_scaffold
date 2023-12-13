package com.example.di_ejercicio_lazycolumn_scaffold

import android.os.Bundle
import android.webkit.WebView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.di_ejercicio_lazycolumn_scaffold.ui.theme.Di_ejercicio_lazycolumn_scaffoldTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WebView.setWebContentsDebuggingEnabled(true)
        setContent {
            Di_ejercicio_lazycolumn_scaffoldTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val snackbarHostState = remember {
                        SnackbarHostState()
                    }
                    val coroutineScope = rememberCoroutineScope()

                    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                    var plataforma by rememberSaveable {
                        mutableStateOf("Todas")

                    }
                    var index by remember {
                        mutableStateOf(0)

                    }
                    var show by rememberSaveable {
                        mutableStateOf(false)
                    }
                    val context = LocalContext.current
                    val scope = rememberCoroutineScope()
                    ModalNavigationDrawer(

                        drawerState = drawerState,

                        gesturesEnabled = false,
                        drawerContent = {
                            ModalDrawerSheet(drawerContainerColor = colorResource(id = R.color.purple_700)) {
                                NavigationDrawerItem(modifier = Modifier
                                    .padding(
                                        top = 10.dp,
                                        end = 5.dp,
                                        start = 5.dp,
                                        bottom = 5.dp
                                    ),

                                    label = {
                                        Text(
                                            text = "Todas",
                                            Modifier.fillMaxWidth(),
                                            fontWeight = FontWeight.SemiBold,
                                            textAlign = TextAlign.Center
                                        )
                                    },
                                    selected = false, onClick = {
                                        scope.launch {
                                            drawerState.close()
                                        }
                                        plataforma = "Todas"
                                    })

                                NavigationDrawerItem(modifier = Modifier.padding(5.dp),
                                    label = {
                                        Text(
                                            text = "Nintendo Switch",
                                            Modifier.fillMaxWidth(),
                                            fontWeight = FontWeight.SemiBold,
                                            textAlign = TextAlign.Center
                                        )
                                    },
                                    selected = false, onClick = {
                                        scope.launch {
                                            drawerState.close()
                                        }
                                        plataforma = "Nintendo Switch"
                                    })
                                NavigationDrawerItem(modifier = Modifier.padding(5.dp),
                                    label = {
                                        Text(
                                            text = "PlayStation 5",
                                            Modifier.fillMaxWidth(),
                                            fontWeight = FontWeight.SemiBold,
                                            textAlign = TextAlign.Center
                                        )
                                    },
                                    selected = false, onClick = {
                                        scope.launch {
                                            drawerState.close()
                                        }
                                        plataforma = "PlayStation 5"
                                    })
                                NavigationDrawerItem(modifier = Modifier.padding(5.dp),
                                    label = {
                                        Text(
                                            text = "XBox Series",
                                            Modifier.fillMaxWidth(),
                                            fontWeight = FontWeight.SemiBold,
                                            textAlign = TextAlign.Center
                                        )
                                    },
                                    selected = false, onClick = {
                                        scope.launch {
                                            drawerState.close()
                                        }
                                        plataforma = "XBox Series"
                                    })
                            }
                        }) {

                        if (show) {
                            var onDismiss = { show = false }
                            Dialog(onDismissRequest = { onDismiss }) {
                                Card(shape = RoundedCornerShape(16.dp)) {


                                    Column(
                                        Modifier
                                            .background(colorResource(id = R.color.purple_200))
                                            .padding(10.dp)
                                    ) {
                                        Box(
                                            modifier = Modifier.fillMaxWidth(),
                                            contentAlignment = Alignment.CenterEnd
                                        ) {
                                            Icon(imageVector = Icons.Default.Close,
                                                contentDescription = "Close app",
                                                modifier = Modifier
                                                    .clickable { onDismiss() }
                                            )
                                        }
                                        Button(
                                            onClick = {
                                                Toast.makeText(
                                                    context,
                                                    "Compartido en Google",
                                                    Toast.LENGTH_LONG
                                                ).show()
                                            },
                                            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.purple_700)),
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(5.dp)
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.SpaceAround,
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.google),
                                                    contentDescription = null,
                                                    modifier = Modifier
                                                        .size(34.dp)
                                                        .padding(4.dp)
                                                )

                                                Text(
                                                    text = "Google account", fontSize = 14.sp,
                                                    color = Color(0xFF4EA8E9),
                                                    lineHeight = 34.sp
                                                )
                                            }


                                        }
                                        Button(
                                            onClick = {
                                                Toast.makeText(
                                                    context,
                                                    "Compartido en Facebook",
                                                    Toast.LENGTH_LONG
                                                ).show()
                                            }, colors = ButtonDefaults.buttonColors(colorResource(id = R.color.purple_700)),modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(5.dp)
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.SpaceAround,
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.facebook),
                                                    contentDescription = null,
                                                    modifier = Modifier
                                                        .size(34.dp)
                                                        .padding(4.dp)
                                                )

                                                Text(
                                                    text = "Facebook account", fontSize = 14.sp,
                                                    color = Color(0xFF4EA8E9),
                                                    lineHeight = 34.sp
                                                )

                                            }
                                        }
                                        Button(
                                            onClick = {
                                                Toast.makeText(
                                                    context,
                                                    "Compartido en LinkedIn",
                                                    Toast.LENGTH_LONG
                                                ).show()
                                            }, colors = ButtonDefaults.buttonColors(colorResource(id = R.color.purple_700)),modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(5.dp)
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.SpaceAround,
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.linkedin),
                                                    contentDescription = null,
                                                    modifier = Modifier
                                                        .size(34.dp)
                                                        .padding(4.dp)

                                                )

                                                Text(
                                                    text = "Linkedin naccount", fontSize = 14.sp,
                                                    color = Color(0xFF4EA8E9),
                                                    lineHeight = 34.sp
                                                )

                                            }
                                        }

                                    }

                                }
                            }
                        }


                        Scaffold(
                            snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
                            topBar = {
                                TopAppBar01(onClickIcon = {
                                    coroutineScope.launch {
                                        snackbarHostState.showSnackbar("$it")


                                    }
                                }, onClickDrawer = { scope.launch { drawerState.open() } })
                            },
                            bottomBar = {


                                NavigationBar(
                                    containerColor = colorResource(id = R.color.purple_700),
                                    contentColor = Color.Transparent
                                ) {
                                    NavigationBarItem(
                                        selected = index == 1,
                                        onClick = {
                                            index = 1
                                        },
                                        icon = {
                                            Icon(
                                                imageVector = Icons.Filled.AccountCircle,
                                                contentDescription = "Mi cuenta",
                                                tint = Color(0xFFBB86FC)
                                            )
                                        },
                                        label = {
                                            Text(
                                                text = "Mi cuenta",
                                                color = colorResource(id = R.color.purple_200)
                                            )
                                        },
                                        colors = NavigationBarItemDefaults.colors(
                                            selectedIconColor = Color.Transparent,
                                            unselectedIconColor = Color.Transparent,
                                            selectedTextColor = Color.Transparent,
                                            indicatorColor = colorResource(id = R.color.purple_700)
                                        )
                                    )
                                    NavigationBarItem(selected = index == 2, onClick = {
                                        index = 2
                                        show = !show

                                    }, icon = {
                                        Icon(
                                            imageVector = Icons.Filled.Share,
                                            contentDescription = "Compartir",
                                            tint = Color(0xFFBB86FC)
                                        )
                                    },
                                        label = {
                                            Text(
                                                text = "Compartir",
                                                color = colorResource(id = R.color.purple_200)
                                            )
                                        },
                                        colors = NavigationBarItemDefaults.colors(
                                            selectedIconColor = Color.Transparent,
                                            unselectedIconColor = Color.Transparent,
                                            selectedTextColor = Color.Transparent,
                                            indicatorColor = colorResource(id = R.color.purple_700)
                                        )
                                    )
                                    var meGusta by rememberSaveable {
                                        mutableStateOf(false)
                                    }
                                    NavigationBarItem(
                                        selected = index == 3,
                                        onClick = {
                                            index = 3
                                            meGusta = !meGusta
                                            Toast.makeText(
                                                context, if (meGusta) {
                                                    "¡Me gusta!"
                                                } else {
                                                    "Ya no me gusta..."
                                                }, Toast.LENGTH_LONG
                                            ).show();

                                        },
                                        icon = {

                                            Icon(
                                                imageVector = if (meGusta) {
                                                    Icons.Filled.Favorite
                                                } else {
                                                    Icons.Filled.FavoriteBorder
                                                },
                                                contentDescription = "Me gusta",
                                                tint = Color(0xFFBB86FC)
                                            )
                                        },
                                        label = {
                                            Text(
                                                text = "Me gusta",
                                                color = colorResource(id = R.color.purple_200)
                                            )
                                        },
                                        colors = NavigationBarItemDefaults.colors(
                                            selectedIconColor = Color.Transparent,
                                            unselectedIconColor = Color.Transparent,
                                            selectedTextColor = Color.Transparent,
                                            indicatorColor = colorResource(id = R.color.purple_700)
                                        )
                                    )

                                }
                            },
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
            }
        }
    }
}