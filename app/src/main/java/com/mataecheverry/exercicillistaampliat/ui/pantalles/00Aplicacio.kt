package com.mataecheverry.exercicillistaampliat.ui.pantalles


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mataecheverry.exercicillistaampliat.R
import com.mataecheverry.exercicillistaampliat.navegacio.CategoriaDeNavegacio
import com.mataecheverry.exercicillistaampliat.navegacio.GraphNavegacio
import com.mataecheverry.exercicillistaampliat.ui.theme.ExerciciLlistaAmpliatTheme

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Aplicacio(content: @Composable ()-> Unit = {Text("")})
{
    PantallaDeLAplicacio {
        val controladorDeNavegacio = rememberNavController()
        val navBackStackEntry by controladorDeNavegacio.currentBackStackEntryAsState()
        val rutaActual = navBackStackEntry?.destination?.route?: "" //Retorna string null si la ruta és null.

        Scaffold(
            topBar = { TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary),
                title = { Text(stringResource(R.string.titolpractica)) },
                navigationIcon = {
                    Image(
                        painterResource(id = R.drawable.avatar_thinking_4_svgrepo_com), contentDescription = "flor",
                        contentScale = ContentScale.Inside,
                        modifier = Modifier
                            .height(32.dp)
                            .width(32.dp)
                    )
                })
            },
            bottomBar = {
                NavigationBar {
                    CategoriaDeNavegacio.values().forEach {
                        NavigationBarItem(
                            label = { Text(text = stringResource(id = it.titol)) },
                            selected = rutaActual.contains(it.rutaPrevia),
                            onClick = { controladorDeNavegacio.navigate(it.rutaPrevia) {
                                popUpTo(controladorDeNavegacio.graph.findStartDestination().id){
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            } },
                            icon = { Icon (it.icona,
                                contentDescription = stringResource(id = (it.titol))
                            )
                            }
                        )
                    }
                }
            }
        )
        {
            Box(modifier = Modifier.padding(paddingValues = it))
            {
                GraphNavegacio(controladorDeNavegacio)
            }
        }
    }
}


@Composable //TemaApp
fun PantallaDeLAplicacio (content: @Composable ()->Unit)
{
    ExerciciLlistaAmpliatTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}