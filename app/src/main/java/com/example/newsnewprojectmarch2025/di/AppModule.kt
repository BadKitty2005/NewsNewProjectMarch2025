package com.example.newsnewprojectmarch2025.di

import android.app.Application
import androidx.room.Room
import com.apollographql.apollo3.ApolloClient
import com.example.newsnewprojectmarch2025.data.local.NewsDatabase
import com.example.newsnewprojectmarch2025.data.repository.NewsRepositoryImpl
import com.example.newsnewprojectmarch2025.domain.repository.NewsRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            NewsDatabase::class.java,
            "news_db"
        ).build()
    }
    single { get<NewsDatabase>().newsDao() }

    single {
        // используем публичный GraphQL (пример)
        val url = "https://graphqlzero.almansi.me/api"
        ApolloClient.Builder().serverUrl(url).build()
    }

    factory<NewsRepository> {
        NewsRepositoryImpl(get(), get())
    }
}