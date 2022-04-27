package com.example.httpmethodsretrofitexample.feature_meme_generator.data.repository

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    fun delete(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                apiInstance.ApiInstance.deleteMeme(id)
                HomeViewModel().refreshMemes()
            } catch (e: IOException) {
                Log.d("MainActivity", "${e}")
                HomeViewModel().refreshMemes()
            }
        }
    }

    fun update(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                apiInstance.ApiInstance.updateMeme(id, myMeme)
                HomeViewModel().refreshMemes()
            } catch (e: IOException) {
                Log.d("MainActivity", "${e}")
                HomeViewModel().refreshMemes()
            }
        }
    }

    fun post() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                apiInstance.ApiInstance.postMeme(myMeme)
                HomeViewModel().refreshMemes()
            } catch (e: IOException) {
                Log.d("MainActivity", "${e}")
                HomeViewModel().refreshMemes()
            }

        }
    }
}

