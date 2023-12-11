package com.mataecheverry.exercicillistaampliat.ui.pantalles

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mataecheverry.exercicillistaampliat.R
import com.mataecheverry.exercicillistaampliat.dades.Planta
import com.mataecheverry.exercicillistaampliat.dades.Plantes

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun PantallaLlistaDePlantes(llista: List<Planta> = Plantes.dadesPlanta,
                            onPlantaClick: (String) -> Unit,
) {
    LazyColumn()
    {
        stickyHeader { Text (
            text = R.string.lista_de_plantas.toString(),
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
                .padding(16.dp),
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.displaySmall,
            textAlign = TextAlign.Center)
        }
        item{
            Text(R.string.lista_de_plantas.toString())
        }
        items(llista)
        {
            var planta = it
            ItemPlanta(planta = it, onPlantaClick = {onPlantaClick(planta.id)})
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemPlanta(planta: Planta, onPlantaClick: (String)-> Unit) {
    ElevatedCard(elevation = CardDefaults.cardElevation(6.dp),
        modifier = Modifier
            .padding(10.dp)
            .background(Color(0XFFffdad3))
            .clickable { onPlantaClick(planta.id) })
    {
        ListItem(
            leadingContent = {
                AsyncImage(model = ImageRequest.Builder(LocalContext.current)
                    .data("https://www.loremflickr.com/300/300/indoorplants?lock=${planta.id}")
                    .crossfade(true)
                    .build(),
                    placeholder= painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .padding(10.dp),
                )
            },
            headlineText = { Text("${planta.id}, ${planta.nom}") },
            supportingText = { Text("${planta.mida}") }

        )
    }
}

