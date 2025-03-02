package com.example.newsnewprojectmarch2025.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsnewprojectmarch2025.domain.model.News
import com.example.newsnewprojectmarch2025.domain.usecase.GetNewsUseCase
import com.example.newsnewprojectmarch2025.domain.usecase.RefreshNewsUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class NewsViewModel(
    private val getNews: GetNewsUseCase,
    private val refresh: RefreshNewsUseCase
) : ViewModel() {

    val newsState: StateFlow<List<News>> = getNews()
        .map { it }
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun refresh() {
        viewModelScope.launch {
            refresh()
        }
    }
}