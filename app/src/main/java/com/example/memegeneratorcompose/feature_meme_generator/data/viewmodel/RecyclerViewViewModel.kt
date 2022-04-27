package com.example.memegeneratorcompose.feature_meme_generator.data.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.arrayOfMemeImg
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.arrayOfMemeText
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.randomImg
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.randomText
import com.example.httpmethodsretrofitexample.feature_meme_generator.di.apiInstance
import com.example.httpmethodsretrofitexample.feature_meme_generator.domain.model.MemeModel
import com.example.httpmethodsretrofitexample.feature_meme_generator.domain.model.PostMemeModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import kotlin.random.Random

class HomeViewModel() : ViewModel() {

    val api = apiInstance.ApiInstance
    val myMeme = PostMemeModel(arrayOfMemeImg[randomImg], arrayOfMemeText[randomText])

    private val _state = MutableStateFlow(emptyList<MemeModel>())
    val state: StateFlow<List<MemeModel>>
        get() = _state


    fun refreshMemes() {
        viewModelScope.launch {
            try {
                val characters = api.getMemes()
                _state.value = characters
            } catch (e: IOException) {
                Log.d("MainActivity", "${e}")
            }
        }
    }
}