package com.example.memegeneratorcompose.feature_meme_generator.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.repository.HomeViewModel
import com.example.httpmethodsretrofitexample.feature_meme_generator.domain.model.MemeModel
import com.example.memegeneratorcompose.R

@Composable
fun CharacterImageCard(character: MemeModel) {
    val imagerPainter = rememberImagePainter(data = character.image)

    Card(
        shape = MaterialTheme.shapes.medium,
    ) {
        Column {
            Image(
                painter = imagerPainter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "PreViewText ${character.text}",
                Modifier.padding(7.dp)
            )
        }
        Row {

            TopLeftButtonDesign(
                icon = R.drawable.edit,
                onPress = HomeViewModel().update(character.id)
            )
            TopLeftButtonDesign(
                icon = R.drawable.delete,
                onPress = HomeViewModel().delete(character.id)
            )

        }
    }
}

@Composable
fun TopLeftButtonDesign(icon: Int, onPress: Unit){
    OutlinedButton(
        onClick = { onPress },

        border = BorderStroke(
            width = 2.dp,
            color = Color.Cyan
        ),
        shape = CutCornerShape(0.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        ),
        modifier = Modifier
            .size(width = 42.dp,
                height = 42.dp
            ),
        contentPadding = PaddingValues(0.dp)
    ) {
        Icon(
            contentDescription = null,
            tint = Color.Cyan,
            painter = painterResource(
                id = icon,
            ),
        )
    }
}