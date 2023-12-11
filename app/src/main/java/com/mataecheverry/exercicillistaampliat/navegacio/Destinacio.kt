package com.mataecheverry.exercicillistaampliat.navegacio

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.mataecheverry.exercicillistaampliat.R

enum class CategoriaDeNavegacio(
    val rutaPrevia: String,
    val icona: ImageVector,
    @StringRes val titol: Int
){
    CategoriaPastissos("LlistaPastissos", Icons.Default.Favorite, R.string.pastissos),
    CategoriaPlantes("LlistaPlantes", Icons.Default.Info, R.string.plantes),
    CategoriaGuerrers("LlistraGuerrers", Icons.Default.Face, R.string.guerrers)
}

sealed class Destinacio (
    val rutaBase: String,
    val argumentDeNavegacio: List<ArgumentDeNavegacio> = emptyList()
){
    val navArgs = argumentDeNavegacio.map {it.toNavArgument()}

    val rutaGenerica = run{
        val clausArguments = argumentDeNavegacio.map {"{${it.clau}}"}
        listOf(rutaBase)
            .plus(clausArguments)
            .joinToString("/")

    }
    object LlistaPastissos: Destinacio(CategoriaDeNavegacio.CategoriaPastissos.rutaPrevia+"/LlistaPastissos")
    object LlistaPlantes: Destinacio(CategoriaDeNavegacio.CategoriaPlantes.rutaPrevia+"/LlistaPlantes")
    object LlistaGuerrers: Destinacio(CategoriaDeNavegacio.CategoriaGuerrers.rutaPrevia+"LlistaGuerrers")
    object DetallPastis: Destinacio(CategoriaDeNavegacio.CategoriaPastissos.rutaPrevia+"/DetallPastis",
        listOf(ArgumentDeNavegacio.IdDetallPastis)){
        fun RutaAmbArguments (idDetallPastis: String) = "$rutaBase/$idDetallPastis"
    }

    object DetallPlanta: Destinacio(CategoriaDeNavegacio.CategoriaPlantes.rutaPrevia+"/DetallPlanta",
        listOf(ArgumentDeNavegacio.IdDetallPlanta)){
        fun RutaAmbArguments (idDetallPlanta: String) = "$rutaBase/$idDetallPlanta"
    }

    object DetallGuerrer: Destinacio(CategoriaDeNavegacio.CategoriaGuerrers.rutaPrevia+"/DetallGuerrer",
        listOf(ArgumentDeNavegacio.IdDetallGuerrer)){
        fun RutaAmbArguments (idDetallGuerrer: String) = "$rutaBase/$idDetallGuerrer"
    }
}

enum class ArgumentDeNavegacio(val clau: String, val tipus: NavType<*>){
    IdDetallPastis("Pastis", NavType.StringType),
    IdDetallPlanta("Planta", NavType.StringType),
    IdDetallGuerrer("Guerrer", NavType.StringType);
    
    fun toNavArgument (): NamedNavArgument {
        return navArgument(clau) { type = tipus }
    }
}