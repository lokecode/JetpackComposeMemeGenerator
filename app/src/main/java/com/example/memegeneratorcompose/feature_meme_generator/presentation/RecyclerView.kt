package com.example.httpmethodsretrofitexample.adapter
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.repository.HomeViewModel
import com.example.httpmethodsretrofitexample.feature_meme_generator.domain.model.MemeModel


@Composable
fun HomeScreen() {
    val HomeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val state by HomeViewModel.state.collectAsState()

    LazyColumn {
        HomeViewModel.refreshMemes()
        if (state.isEmpty()) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(align = Alignment.Center)
                )
            }

        }

        items(state) { character: MemeModel ->
            CharacterImageCard(character = character)
        }


    }

}

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
                text = "Real name: ${character.text}",
                Modifier.padding(7.dp)
            )
        }
        Row {
            Button(
                onClick = { },
            ) {
                Text(text = "MEEE!!")
            }
            Button(
                onClick = { },
            ) {
                Text(text = "MEEE!!")
            }
        }
    }
}

@Preview
@Composable
fun myPreview(){
    CharacterImageCard(MemeModel("","","",))
}