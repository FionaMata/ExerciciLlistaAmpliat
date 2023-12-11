package com.mataecheverry.exercicillistaampliat.navegacio

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.mataecheverry.exercicillistaampliat.dades.Guerrers
import com.mataecheverry.exercicillistaampliat.dades.Pastissos
import com.mataecheverry.exercicillistaampliat.dades.Plantes
import com.mataecheverry.exercicillistaampliat.ui.pantalles.*


@Composable
fun GraphNavegacio(controladorDeNavegacio: NavHostController = rememberNavController())
{
    NavHost(navController = controladorDeNavegacio, startDestination = CategoriaDeNavegacio.CategoriaPastissos.rutaPrevia)
    {

        navigation(startDestination=Destinacio.LlistaPastissos.rutaGenerica,
            route=CategoriaDeNavegacio.CategoriaPastissos.rutaPrevia
        ) {
            composable(route = Destinacio.LlistaPastissos.rutaGenerica){
                PantallaLlistaPastissos(
                    onPastisClick = {pastis: String ->
                        Log.d("fiona", "GraphNavegacio: ${Destinacio.DetallPastis.rutaGenerica}")
                        controladorDeNavegacio.navigate(Destinacio.DetallPastis.RutaAmbArguments(pastis))
                                    },
                    )
                }
            composable(route = Destinacio.DetallPastis.rutaGenerica,
                arguments = Destinacio.DetallPastis.navArgs){
                val pastis = it.arguments?.getString(ArgumentDeNavegacio.IdDetallPastis.clau)
                requireNotNull(pastis)
                DetallPastis(pastis)
            }
        }

        navigation(startDestination=Destinacio.LlistaPlantes.rutaGenerica,
           CategoriaDeNavegacio.CategoriaPlantes.rutaPrevia){
            composable(Destinacio.LlistaPlantes.rutaGenerica){
                PantallaLlistaDePlantes(
                    Plantes.dadesPlanta,
                    onPlantaClick = {planta: String ->
                        controladorDeNavegacio.navigate(Destinacio.DetallPlanta.RutaAmbArguments(planta)) },
                    )
                }
            composable(route=Destinacio.DetallPlanta.rutaGenerica, arguments=Destinacio.DetallPlanta.navArgs){
                val planta = it.arguments?.getString(ArgumentDeNavegacio.IdDetallPlanta.clau)
                requireNotNull(planta)
                DetallPlanta(planta = planta)
            }
        }

        navigation(startDestination=Destinacio.LlistaGuerrers.rutaGenerica,
            CategoriaDeNavegacio.CategoriaGuerrers.rutaPrevia){
            composable(Destinacio.LlistaGuerrers.rutaGenerica){
                PantallaLlistaGuerrers(
                    Guerrers.dades,
                ) { guerrer: String ->
                    controladorDeNavegacio.navigate(
                        Destinacio.DetallGuerrer.RutaAmbArguments(
                            guerrer
                        )
                    )
                }
            }
            composable(route=Destinacio.DetallGuerrer.rutaGenerica, arguments = Destinacio.DetallGuerrer.navArgs){
                val guerrer = it.arguments?.getString(ArgumentDeNavegacio.IdDetallGuerrer.clau)
                requireNotNull(guerrer)
                DetallGuerrer(guerrer)
            }
        }
    }
}
