package com.example.httpmethodsretrofitexample.feature_meme_generator.data.repository

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.httpmethodsretrofitexample.adapter.HomeScreen
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.arrayOfMemeImg
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.arrayOfMemeText
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.randomImg
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.randomText
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.remote.MemeApis
import com.example.httpmethodsretrofitexample.feature_meme_generator.di.apiInstance
import com.example.httpmethodsretrofitexample.feature_meme_generator.di.apiInstance.ApiInstance
import com.example.httpmethodsretrofitexample.feature_meme_generator.domain.model.MemeModel
import com.example.httpmethodsretrofitexample.feature_meme_generator.domain.model.PostMemeModel
import com.example.memegeneratorcompose.feature_meme_generator.data.viewmodel.HomeViewModel
import com.example.memegeneratorcompose.feature_meme_generator.data.viewmodel.test9000.Companion._state
import com.example.memegeneratorcompose.feature_meme_generator.data.viewmodel.test9000.Companion.api
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import kotlin.random.Random


class RecyclerViewRepository {
    val myMeme = PostMemeModel(arrayOfMemeImg[randomImg], arrayOfMemeText[randomText])

    fun generateMeme() {
        randomImg = Random.nextInt(8)
        randomText = Random.nextInt(8)
    }

    fun refreshMemes() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val characters = api.getMemes()
                _state.value = characters
            } catch (e: IOException) {
                Log.d("MainActivity", "${e}")
            }
        }
    }

    fun delete(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                apiInstance.ApiInstance.deleteMeme(id)
                refreshMemes()
            } catch (e: IOException) {
                Log.d("MainActivity", "${e}")
                refreshMemes()
            }
        }
    }

    fun update(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                apiInstance.ApiInstance.updateMeme(id, myMeme)
                refreshMemes()
            } catch (e: IOException) {
                Log.d("MainActivity", "${e}")
                refreshMemes()
            }
        }
    }

    fun post() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                apiInstance.ApiInstance.postMeme(myMeme)
                refreshMemes()
            } catch (e: IOException) {
                Log.d("MainActivity", "${e}")
                refreshMemes()
            }

        }
    }
}

