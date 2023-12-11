package com.mataecheverry.exercicillistaampliat.dades

import com.mataecheverry.exercicillistaampliat.R

data class Pastis(
    val id: String,
    val nom: Int,
    val foto: String,
    val ingredients: MutableList<*>,
    val passos: String,

    )

class Pastissos{
    companion object {
        private fun generaPastis(id: Int): Pastis {
            var llistaIngredients: MutableList<*> = CreaLlistaDingredients()
            return Pastis(
                id = id.toString(),
                nom = pastisRandom(),
                foto = "https://loremflickr.com/300/300/pastries?lock=$id",
                ingredients = llistaIngredients,
                passos = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\" "
            )
        }

        val dades = (0..100).toList().map { generaPastis(it) };
    }
}

fun CreaLlistaDingredients(): MutableList<Int>{
    val llistaIngredients = mutableListOf<Int>()
    var ingredient: Int
    var i: Int = 0

    while (i < 5){
        ingredient = ingredientsRandom()
        llistaIngredients.add(ingredient)
        i++
    }
    return llistaIngredients
}

fun pastisRandom(): Int {

    val pastissos = listOf(
        R.string.apfelstrudel,
        R.string.berliner,
        R.string.bienenstich,
        R.string.lebkuchen,
        R.string.stollen,
        R.string.windbeutel,
        R.string.nussecken,
        R.string.k_sekuchen,
        R.string.quarkb_llchen,
        R.string.churro,
        R.string.ensaimada,
        R.string.bu_uelos,
        R.string.crema_catalana,
        R.string.magdalena,
        R.string.napolitana_de_chocolate,
        R.string.rosquillas,
        R.string.turr_n,
        R.string.polvor_n,
        R.string.pesti_os,
        R.string.torrijas,
        R.string.scone,
        R.string.bakewell_tart,
        R.string.victoria_sponge,
        R.string.battenberg_cake,
        R.string.biscuit_cookie,
        R.string.sticky_toffee_pudding,
        R.string.custard_tart,
        R.string.bread_and_butter_pudding,
        R.string.spotted_dick,
        R.string.croissant,
        R.string.baguette,
        R.string.clair,
        R.string.tarte_tatin,
        R.string.mille_feuille,
        R.string.palmier,
        R.string.financier,
        R.string.cannele,
        R.string.chausson_aux_pommes,
        R.string.baba_au_rhum
    )
    var llistaPastissos = pastissos.random()
    return llistaPastissos
}

fun ingredientsRandom(): Int {

    val ingredients = listOf(
        R.string.all_purpose_flour,
        R.string.sugar,
        R.string.butter,
        R.string.eggs,
        R.string.baking_powder,
        R.string.baking_soda,
        R.string.vanilla_extract,
        R.string.milk,
        R.string.salt,
        R.string.yeast,
        R.string.cocoa_powder,
        R.string.chocolate_chips,
        R.string.nuts_e_g_almonds_walnuts,
        R.string.cinnamon,
        R.string.nutmeg,
        R.string.cream_cheese,
        R.string.cornstarch,
        R.string.honey,
        R.string.maple_syrup,
        R.string.oats,
        R.string.lemon_zest,
        R.string.orange_zest,
        R.string.almond_extract,
        R.string.hazelnuts,
        R.string.pistachios,
        R.string.raisins,
        R.string.buttermilk,
        R.string.sour_cream,
        R.string.greek_yogurt,
        R.string.poppy_seeds,
        R.string.coconut_flakes,
        R.string.caramel_sauce,
        R.string.peanut_butter,
        R.string.chocolate,
        R.string.rum_or_brandy_for_flavoring,
        R.string.espresso_powder
    )
   return ingredients.random()
}

