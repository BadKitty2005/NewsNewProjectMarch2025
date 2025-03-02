package com.example.newsnewprojectmarch2025.data.remote

import com.apollographql.apollo3.ApolloClient

object ApolloClientProvider {
    fun create(url: String): ApolloClient =
        ApolloClient.Builder()
            .serverUrl(url)
            .build()
}