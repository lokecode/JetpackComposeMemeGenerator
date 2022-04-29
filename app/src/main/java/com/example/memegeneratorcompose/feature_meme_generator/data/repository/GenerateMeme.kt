package com.example.memegeneratorcompose.feature_meme_generator.data.repository
import com.example.memegeneratorcompose.feature_meme_generator.data.repository.GenerateMeme.Index.randomImg
import com.example.memegeneratorcompose.feature_meme_generator.data.repository.GenerateMeme.Index.randomText
import kotlin.random.Random

class GenerateMeme {
    object Index {
        var randomImg = 0
        var randomText = 0
    }

    fun generateMeme() {
        randomImg = Random.nextInt(8)
        randomText = Random.nextInt(8)
    }
}