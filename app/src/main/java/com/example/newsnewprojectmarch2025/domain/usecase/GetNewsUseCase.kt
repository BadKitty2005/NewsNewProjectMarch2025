package com.example.newsnewprojectmarch2025.domain.usecase

import com.example.newsnewprojectmarch2025.domain.model.News
import com.example.newsnewprojectmarch2025.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNewsUseCase(private val repo: NewsRepository) {
    operator fun invoke(): Flow<List<News>> = repo.getNewsStream()
}