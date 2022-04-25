package com.example.memegeneratorcompose.feature_meme_generator.data.local

import kotlin.random.Random
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.randomImg
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.randomText

object MemeGeneratorViewModel {
    fun generateMeme(){
        randomImg = Random.nextInt(8)
        randomText = Random.nextInt(8)
    }
}