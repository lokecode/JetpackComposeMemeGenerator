package com.example.httpmethodsretrofitexample.adapter
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.httpmethodsretrofitexample.feature_meme_generator.di.ApiCaller
import com.example.httpmethodsretrofitexample.feature_meme_generator.domain.model.MemeModel
import com.example.memegeneratorcompose.feature_meme_generator.data.viewmodel.HomeViewModel
import com.example.memegeneratorcompose.feature_meme_generator.presentation.CharacterImageCard


@Composable
fun HomeScreen() {
    val HomeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val state by HomeViewModel.state.collectAsState()

    LazyColumn {
        ApiCaller().refreshMemes(HomeViewModel._state)
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

