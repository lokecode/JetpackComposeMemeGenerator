package com.example.memegeneratorcompose.feature_meme_generator.data.viewmodel

import androidx.lifecycle.ViewModel
import com.example.httpmethodsretrofitexample.feature_meme_generator.domain.model.MemeModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class HomeViewModel() : ViewModel() {
        val _state = MutableStateFlow(emptyList<MemeModel>())
        val state: StateFlow<List<MemeModel>>
            get() = _state

}