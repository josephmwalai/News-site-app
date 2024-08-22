package com.example.newssite.models

data class NewsData(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)