package com.example.newsnewprojectmarch2025.domain.usecase

import com.example.newsnewprojectmarch2025.domain.repository.NewsRepository

class RefreshNewsUseCase(private val repo: NewsRepository) {
    suspend operator fun invoke() = repo.refreshNews()
}