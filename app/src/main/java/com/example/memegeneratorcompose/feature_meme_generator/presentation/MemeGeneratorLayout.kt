package com.example.memegeneratorcompose.feature_meme_generator.presentation

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.arrayOfMemeImg
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.arrayOfMemeText
import com.example.httpmethodsretrofitexample.feature_meme_generator.di.ApiCaller
import com.example.memegeneratorcompose.R
import com.example.memegeneratorcompose.feature_meme_generator.data.repository.GenerateMeme
import com.example.memegeneratorcompose.feature_meme_generator.data.repository.GenerateMeme.Index.randomImg
import com.example.memegeneratorcompose.feature_meme_generator.data.repository.GenerateMeme.Index.randomText

@Composable
fun MemeGeneratorLayout() {
    val memeImg = remember {
        mutableStateOf(arrayOfMemeImg[1])
    }
    val memeText = remember {
        mutableStateOf(arrayOfMemeText[5])
    }



    Column(
        verticalArrangement = Arrangement.Bottom
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .clip(RoundedCornerShape(topStart = 16.dp))
                .clip(RoundedCornerShape(topEnd = 16.dp))
                .background(color = Color(0x8A000000)),
        ){
            Row{
                OutlinedButton(
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0x0)
                    ),
                    border = BorderStroke(
                        width = 0.dp,
                        color = Color.Transparent
                    ),
                    contentPadding = PaddingValues(0.dp),
                    onClick = {
                        GenerateMeme().generateMeme()
                        memeImg.value = arrayOfMemeImg[randomImg];
                        memeText.value = arrayOfMemeText[randomText];
                    }
                ) {
                    Icon(
                        contentDescription = null,
                        tint = Color.Cyan,
                        painter = painterResource(
                            id = R.drawable.generate,
                        ),
                        modifier = Modifier
                            .width(47.dp)
                            .fillMaxHeight()
                    )
                }
                Image(
                    painter = rememberImagePainter(data = memeImg.value),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight(),


                )
                Text(
                    text = memeText.value,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(13.dp),
                    color = Color.White
                )
            }
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                OutlinedButton(
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0x0)
                    ),
                    border = BorderStroke(
                        width = 0.dp,
                        color = Color.Transparent
                    ),
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier
                        .width(50.dp)
                        .fillMaxHeight(),
                    onClick = { ApiCaller().post() }
                ) {
                    Icon(
                        contentDescription = null,
                        tint = Color.Cyan,
                        painter = painterResource(
                            id = R.drawable.post,
                        ),
                        modifier = Modifier
                            .width(40.dp)
                            .fillMaxHeight()
                    )
                }
            }
        }
    }
}

@Composable
fun button(onPress: Unit, icon: Int, ) {
    OutlinedButton(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0x0)
        ),
        border = BorderStroke(
            width = 0.dp,
            color = Color.Transparent
        ),
        contentPadding = PaddingValues(0.dp),
        onClick = {
            onPress
        }
    ) {
        Icon(
            contentDescription = null,
            tint = Color.Cyan,
            painter = painterResource(
                id = icon,
            ),
            modifier = Modifier
                .width(47.dp)
                .fillMaxHeight()
        )
    }
}