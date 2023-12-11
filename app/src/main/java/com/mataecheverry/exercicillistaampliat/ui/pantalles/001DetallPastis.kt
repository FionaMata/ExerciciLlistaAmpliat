package com.mataecheverry.exercicillistaampliat.ui.pantalles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mataecheverry.exercicillistaampliat.R
import com.mataecheverry.exercicillistaampliat.dades.Pastissos

@Composable
fun DetallPastis(id: String) {
    val num = id.toInt()

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
        .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        AsyncImage(model = ImageRequest.Builder(LocalContext.current)
            .data("https://www.loremflickr.com/300/300/guerrer?lock=${Pastissos.dades[num].id}")
            .crossfade(true)
            .build(),
            placeholder= painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier

                .weight(0.3F)
                .clip(CircleShape)
                .padding(10.dp)
        )
        Text(text = "${Pastissos.dades[num].nom}",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .weight(0.3F),
        )

        Divider(thickness = 2.dp,
            color = MaterialTheme.colorScheme.onBackground)
        //${ stringResource(id = pastis.nom) }

        Text(text= "${Pastissos.dades[num].ingredients}")
    }
}
