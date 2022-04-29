package com.example.memegeneratorcompose.feature_meme_generator.presentation

import android.util.DisplayMetrics
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.httpmethodsretrofitexample.feature_meme_generator.di.ApiCaller
import com.example.httpmethodsretrofitexample.feature_meme_generator.domain.model.MemeModel
import com.example.memegeneratorcompose.R
import com.example.memegeneratorcompose.feature_meme_generator.data.viewmodel.HomeViewModel


@Composable
fun CharacterImageCard(character: MemeModel) {
    val HomeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val imagerPainter = rememberImagePainter(data = character.image)
    val width = LocalConfiguration.current.screenWidthDp

    Card{
        Column {
            Image(
                painter = imagerPainter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(width.dp)
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
                onClick = {
                    ApiCaller().update(character.id)
                    ApiCaller().refreshMemes(HomeViewModel._state)
                },

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
                onClick = {
                    ApiCaller().delete(character.id)
                    ApiCaller().refreshMemes(HomeViewModel._state)
                },

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

