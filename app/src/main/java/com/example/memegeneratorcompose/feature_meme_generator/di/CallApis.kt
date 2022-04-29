package com.example.httpmethodsretrofitexample.feature_meme_generator.di

import com.example.httpmethodsretrofitexample.feature_meme_generator.data.remote.MemeApis
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.repository.MemeApisRepository
import com.example.httpmethodsretrofitexample.feature_meme_generator.domain.model.MemeModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiCaller {
    private val apiInstance by lazy {
        Retrofit.Builder()
            .baseUrl(MemeApis.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MemeApis::class.java)
    }

    fun refreshMemes(state: MutableSharedFlow<List<MemeModel>>) {
        MemeApisRepository(apiInstance).refreshMemes(state)
    }
    fun post() {
        MemeApisRepository(apiInstance).post()
    }

    fun delete(id: String){
        MemeApisRepository(apiInstance).delete(id)
    }
    fun update(id: String){
        MemeApisRepository(apiInstance).update(id)
    }

}


