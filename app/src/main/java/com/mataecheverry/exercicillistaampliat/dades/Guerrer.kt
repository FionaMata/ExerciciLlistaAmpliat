package com.mataecheverry.exercicillistaampliat.dades

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

data class Guerrer(
    val id: String,
    val nom: String,
    val foto: String,
    val color: Color,
    val edat: Int,
    val forsa: Int,
    val resistencia: Int,
    val atac: Int,
    val defensa: Int
)

class Guerrers{
    companion object {
        private fun generaGuerrer(id: Int): Guerrer {
            return Guerrer(
                id = id.toString(),
                nom = nomRandom(),
                foto = "https://loremflickr.com/300/300/warriors?lock=$id",
                color = Color(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256)),
                edat = Random.nextInt(67),
                forsa = Random.nextInt(300),
                resistencia = Random.nextInt(300),
                atac = Random.nextInt(300),
                defensa = Random.nextInt(300)
            )
        }

        val dades = (0..100).toList().map { generaGuerrer(it) };
    }
}

fun nomRandom(): String {

    val noms = listOf(
        "Ares",
        "Kratos",
        "Athena",
        "Odin",
        "Thor",
        "Freya",
        "Ezio",
        "Altair",
        "Leonidas",
        "Cassandra",
        "Raiden",
        "Sonya",
        "Scorpion",
        "Morrigan",
        "Arthas",
        "Illidan",
        "Sylvanas",
        "Sauron",
        "Aragorn",
        "Legolas",
        "Geralt",
        "Ciri",
        "Triss",
        "Ezreal",
        "Fiora",
        "Lancelot",
        "Guinevere",
        "Perseus",
        "Atalanta",
        "Hercules",
        "Achilles",
        "Xena",
        "Gabrielle",
        "Beowulf",
        "Valkyrie",
        "Dante",
        "Nero",
        "Cassandra",
        "Thane",
        "Marauder",
        "Tyrael",
        "Leona",
        "Ashe",
        "Darius"
    )
    var nom = noms.random()
    return nom
}
