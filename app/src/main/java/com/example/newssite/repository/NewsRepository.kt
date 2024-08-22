package com.example.newssite.repository

import androidx.room.Query
import com.example.newssite.api.RetrofitInstance
import com.example.newssite.db.articleDatabase
import com.example.newssite.models.Article
import java.util.Locale.IsoCountryCode

class NewsRepository(val db: articleDatabase) {

    suspend fun getHeadlines(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getHeadlines(countryCode, pageNumber)

    suspend fun searchForNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDAO().upsert(article)

    fun getFavouritesNews() = db.getArticleDAO().getAllArticles()

    suspend fun deleteArticles(article: Article) = db.getArticleDAO().deleteArticle(article)
}