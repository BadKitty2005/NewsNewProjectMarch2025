package com.example.newsnewprojectmarch2025.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.newsnewprojectmarch2025.domain.model.News
import com.example.newsnewprojectmarch2025.presentation.viewmodel.NewsViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun NewsScreen(viewModel: NewsViewModel = getViewModel()) {
    val news by viewModel.newsState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("NewsFlow") }, actions = {
                IconButton(onClick = { viewModel.refresh() }) {
                    Icon(Icons.Default.Refresh, contentDescription = "Refresh")
                }
            })
        }
    ) { padding ->
        if (news.isEmpty()) {
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(padding), contentAlignment = androidx.compose.ui.Alignment.Center) {
                Text("Нет новостей. Нажмите Refresh.")
            }
        } else {
            LazyColumn(modifier = Modifier.padding(8.dp)) {
                items(news) { item ->
                    NewsItem(item)
                    Divider()
                }
            }
        }
    }
}

@Composable
fun NewsItem(item: News) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
    ) {
        Text(text = item.title, style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = item.body, style = MaterialTheme.typography.body2, maxLines = 3)
        Spacer(modifier = Modifier.height(6.dp))
        Text(text = "— ${item.author}", style = MaterialTheme.typography.caption)
    }
}