package com.example.newsnewprojectmarch2025.data.mapper

import com.example.newsnewprojectmarch2025.data.local.NewsEntity
import com.example.newsnewprojectmarch2025.domain.model.News
import com.example.newsnewprojectmarch2025.GetPostsQuery

object NewsMapper {
    fun remoteToEntity(item: GetPostsQuery.Data.Data): NewsEntity {
        val idLong = item.id?.toLong() ?: 0L
        val title = item.title ?: ""
        val body = item.body ?: ""
        val author = item.user?.name ?: "Unknown"
        return NewsEntity(id = idLong, title = title, body = body, author = author)
    }

    fun entityToDomain(e: NewsEntity): News =
        News(id = e.id, title = e.title, body = e.body, author = e.author)
}