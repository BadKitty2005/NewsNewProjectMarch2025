package com.example.newsnewprojectmarch2025.domain.repository

import com.example.newsnewprojectmarch2025.domain.model.News
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNewsStream(): Flow<List<News>>
    suspend fun refreshNews(): Result<Unit>
}