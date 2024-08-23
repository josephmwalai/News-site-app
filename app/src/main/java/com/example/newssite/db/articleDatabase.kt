package com.example.newssite.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.newssite.models.Article


@Database(
    entities = [Article::class],
    version = 4
)
@TypeConverters(Converters::class)
abstract class articleDatabase: RoomDatabase() {

    abstract fun getArticleDAO(): ArticleDAO
    companion object {
        @Volatile
        private var instance: articleDatabase? = null
        private val LOCK = Any()
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, articleDatabase::class.java,
                "article_db.db").fallbackToDestructiveMigration().build()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }
    }
}
