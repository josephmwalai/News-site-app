package com.example.newssite.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "articles")
data class Article(
    @PrimaryKey(autoGenerate = true)
    val Id: Int = 0, // Providing a default value for Id
    val author: String? = null, // Making author nullable
    val content: String? = null, // Making content nullable
    val description: String? = null, // Making description nullable
    val publishedAt: String? = null, // Making publishedAt nullable
    val source: Source? = null, // Making source nullable if necessary
    val title: String? = null, // Making title nullable
    val url: String? = null, // Making url nullable
    val urlToImage: String? = null // Making urlToImage nullable
) : Serializable {
    override fun hashCode(): Int {
        var result = Id.hashCode()
        result = 31 * result + (title?.hashCode() ?: 0)
        result = 31 * result + (content?.hashCode() ?: 0)
        result = 31 * result + (author?.hashCode() ?: 0)
        return result
    }
}
