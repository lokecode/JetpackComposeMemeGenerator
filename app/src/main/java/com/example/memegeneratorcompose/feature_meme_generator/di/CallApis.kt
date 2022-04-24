package com.example.httpmethodsretrofitexample.feature_meme_generator.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.remote.MemeApis
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.repository.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object apiInstance {
    val ApiInstance by lazy {
        Retrofit.Builder()
            .baseUrl(MemeApis.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MemeApis::class.java)
    }
}


