package com.example.httpmethodsretrofitexample.feature_meme_generator.data.repository

import android.util.Log
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.arrayOfMemeImg
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.arrayOfMemeText
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.remote.MemeApis
import com.example.httpmethodsretrofitexample.feature_meme_generator.domain.model.MemeModel
import com.example.httpmethodsretrofitexample.feature_meme_generator.domain.model.PostMemeModel
import com.example.memegeneratorcompose.feature_meme_generator.data.repository.GenerateMeme.Index.randomImg
import com.example.memegeneratorcompose.feature_meme_generator.data.repository.GenerateMeme.Index.randomText
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import java.io.IOException

class MemeApisRepository(
    Api: MemeApis
) {
    private val myMeme = PostMemeModel(arrayOfMemeImg[randomImg], arrayOfMemeText[randomText])
    private val api = Api


    fun refreshMemes(state: MutableSharedFlow<List<MemeModel>>) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val characters = api.getMemes()
                state.emit(characters)
            } catch (e: IOException) {
                Log.d("MainActivity", "${e}")
            }
        }
    }

    fun delete(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                api.deleteMeme(id)
            } catch (e: IOException) {
                Log.d("MainActivity", "${e}")
            }
        }
    }

    fun update(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                api.updateMeme(id, myMeme)
            } catch (e: IOException) {
                Log.d("MainActivity", "${e}")
            }
        }
    }

    fun post() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                api.postMeme(myMeme)
            } catch (e: IOException) {
                Log.d("MainActivity", "${e}")
            }

        }
    }
}

