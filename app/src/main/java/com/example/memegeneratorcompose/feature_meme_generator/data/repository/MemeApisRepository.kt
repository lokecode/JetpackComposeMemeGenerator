package com.example.httpmethodsretrofitexample.feature_meme_generator.data.repository

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.arrayOfMemeImg
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.arrayOfMemeText
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.randomImg
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.randomText
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.remote.MemeApis
import com.example.httpmethodsretrofitexample.feature_meme_generator.di.apiInstance.ApiInstance
import com.example.httpmethodsretrofitexample.feature_meme_generator.domain.model.MemeModel
import com.example.httpmethodsretrofitexample.feature_meme_generator.domain.model.PostMemeModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


class HomeViewModel() : ViewModel() {

    val api = ApiInstance
    val myMeme = PostMemeModel(arrayOfMemeImg[randomImg], arrayOfMemeText[randomText])
    private val _state = MutableStateFlow(emptyList<MemeModel>())
    val state: StateFlow<List<MemeModel>>
        get() = _state


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
                api.deleteMeme(id)
                refreshMemes()
            } catch (e: IOException) {
                Log.d("MainActivity", "${e}")
            }
        }
    }

    fun update(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                api.updateMeme(id, myMeme)
                refreshMemes()
            } catch (e: IOException) {
                refreshMemes()
                Log.d("MainActivity", "${e}")
            }
        }
    }

    fun post() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                api.postMeme(myMeme)
                refreshMemes()
            } catch (e: IOException) {
                Log.d("MainActivity", "${e}")
            }

        }
    }


}