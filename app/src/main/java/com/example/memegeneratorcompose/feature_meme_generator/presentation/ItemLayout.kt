package com.example.memegeneratorcompose.feature_meme_generator.presentation

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.repository.RecyclerViewRepository
import com.example.httpmethodsretrofitexample.feature_meme_generator.domain.model.MemeModel
import com.example.memegeneratorcompose.R


@Composable
fun CharacterImageCard(character: MemeModel) {
    val imagerPainter = rememberImagePainter(data = character.image)

    Card{
        Column {
            Image(
                painter = imagerPainter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .background(color = Color.Black)
                    .clip(shape = RoundedCornerShape(25.dp)),
                contentScale = ContentScale.Crop
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Black)
            ) {
                Text(
                    text = character.text,
                    fontSize = 23.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(7.dp),
                )
            }
        }
        Row {
            OutlinedButton(
                onClick = { RecyclerViewRepository().update(character.id) },

                shape = CutCornerShape(0.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0x5B000000)
                ),
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 25.dp))
                    .size(
                        width = 42.dp,
                        height = 42.dp
                    ),
                contentPadding = PaddingValues(0.dp)
            ) {
                Icon(
                    contentDescription = null,
                    tint = Color.Cyan,
                    painter = painterResource(
                        id = R.drawable.edit,
                    ),
                )
            }

            OutlinedButton(
                onClick = { RecyclerViewRepository().delete(character.id) },

                shape = CutCornerShape(0.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0x5B000000)
                ),
                modifier = Modifier
                    .clip(RoundedCornerShape(bottomEnd = 25.dp))
                    .size(
                        width = 42.dp,
                        height = 42.dp
                    ),
                contentPadding = PaddingValues(0.dp)
            ) {
                Icon(
                    contentDescription = null,
                    tint = Color.Cyan,
                    painter = painterResource(
                        id = R.drawable.delete,
                    ),
                )
            }

        }
    }
}

