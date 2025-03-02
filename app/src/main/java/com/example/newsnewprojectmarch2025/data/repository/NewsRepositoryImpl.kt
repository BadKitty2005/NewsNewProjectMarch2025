package com.example.newsnewprojectmarch2025.data.repository

import com.apollographql.apollo3.ApolloClient
import com.example.newsnewprojectmarch2025.GetPostsQuery
import com.example.newsnewprojectmarch2025.data.local.NewsDao
import com.example.newsnewprojectmarch2025.data.mapper.NewsMapper
import com.example.newsnewprojectmarch2025.domain.model.News
import com.example.newsnewprojectmarch2025.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart

class NewsRepositoryImpl(
    private val apollo: ApolloClient,
    private val dao: NewsDao
) : NewsRepository {

    override fun getNewsStream(): Flow<List<News>> {
        // отдаём поток из БД (offline-first)
        return dao.getAll()
            .map { list -> list.map { NewsMapper.entityToDomain(it) } }
    }

    override suspend fun refreshNews(): Result<Unit> {
        return try {
            val response = apollo.query(GetPostsQuery(page = 1, limit = 30)).execute()
            val posts = response.data?.posts?.data ?: emptyList()
            val entities = posts.map { NewsMapper.remoteToEntity(it) }
            dao.insertAll(entities)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}