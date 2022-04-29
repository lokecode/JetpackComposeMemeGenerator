package com.example.memegeneratorcompose.feature_meme_generator.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.httpmethodsretrofitexample.feature_meme_generator.domain.model.MemeModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class HomeViewModel() : ViewModel() {
    val _state = MutableSharedFlow<List<MemeModel>>()

    val state: SharedFlow<List<MemeModel>>
        get() = _state


}