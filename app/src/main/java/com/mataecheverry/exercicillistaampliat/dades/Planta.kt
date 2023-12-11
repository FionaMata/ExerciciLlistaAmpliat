package com.mataecheverry.exercicillistaampliat.dades

import com.mataecheverry.exercicillistaampliat.R
import kotlin.random.Random

data class Planta(
    val id: String,
    val nom: String,
    val foto: String,
    val nivellHumitat: Int,
    val llum: Int,
    val temperatura: Int,
    val mida: Int,
    val rec: Int,
    val fertilitzant: Int

)

class Plantes{
    companion object {
        private fun generaPlanta(id: Int): Planta {
            return Planta(
                id = id.toString(),
                nom = plantaRandom(),
                foto = "https://loremflickr.com/300/300/plants?lock=$id",
                nivellHumitat = Random.nextInt(100),
                llum = R.string.llum_clara_i_indirecta,
                temperatura = R.string._15_38_c,
                mida = randomMida(),
                rec = R.string.riego,
                fertilitzant = R.string.fertilizante
            )
        }

        val dadesPlanta = (0..100).toList().map { generaPlanta(it) };
    }
}

fun plantaRandom(): String {

    val planta = listOf(
        "Sansevieria trifasciata",
        "Spider Plant (Chlorophytum comosum)",
        "Peace Lily (Spathiphyllum)",
        "Fiddle Leaf Fig (Ficus lyrata)",
        "ZZ Plant (Zamioculcas zamiifolia)",
        "Rubber Plant (Ficus elastica)",
        "Pothos (Epipremnum aureum)",
        "Monstera Deliciosa",
        "Aloe Vera (Aloe barbadensis miller)",
        "Succulents (Various species)",
        "Chinese Evergreen (Aglaonema)",
        "Philodendron (Various species)",
        "Boston Fern (Nephrolepis exaltata)",
        "Parlor Palm (Chamaedorea elegans)",
        "Calathea (Various species)",
        "Jade Plant (Crassula ovata)",
        "African Violet (Saintpaulia)",
        "Bamboo Palm (Chamaedorea seifrizii)",
        "Cast Iron Plant (Aspidistra elatior)",
        "Devil's Ivy (Epipremnum aureum)",
        "Areca Palm (Dypsis lutescens)",
        "String of Pearls (Senecio rowleyanus)",
        "Bird of Paradise (Strelitzia reginae)",
        "ZZ Raven Plant (Zamioculcas zamiifolia 'Raven')",
        "Swiss Cheese Plant (Monstera adansonii)",
        "Spiderette Plant (Chlorophytum comosum 'Bonnie')",
        "Nerve Plant (Fittonia)",
        "Lucky Bamboo (Dracaena sanderiana)",
        "Majesty Palm (Ravenea rivularis)",
        "String of Hearts (Ceropegia woodii)",
        "Golden Pothos (Epipremnum aureum 'Marble Queen')",
        "Yucca Plant (Yucca elephantipes)",
        "Cactus (Various species)",
        "Elephant Ear Plant (Alocasia)",
        "Lipstick Plant (Aeschynanthus radicans)",
        "Pilea Peperomioides",
        "Begonia (Various species)",
        "Fern Arum (Nephrolepis exaltata 'Bostoniensis')",
        "Dieffenbachia (Dieffenbachia seguine)"
    )
    var nom = planta.random()
    return nom
}

fun randomMida(): Int {
    val mides = listOf(
        R.string.grande,
        R.string.mediana,
        R.string.peque_a
    )
    var mida = mides.random()
    return mida
}
