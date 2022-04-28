package com.example.httpmethodsretrofitexample.adapter
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.repository.RecyclerViewRepository
import com.example.httpmethodsretrofitexample.feature_meme_generator.domain.model.MemeModel
import com.example.memegeneratorcompose.feature_meme_generator.data.viewmodel.HomeViewModel
import com.example.memegeneratorcompose.feature_meme_generator.presentation.CharacterImageCard


@Composable
fun HomeScreen() {
    val HomeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val state by HomeViewModel.statee.collectAsState()


    LazyColumn {
        RecyclerViewRepository().refreshMemes()
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

