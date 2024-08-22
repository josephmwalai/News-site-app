package com.example.newssite.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.newssite.R
import com.example.newssite.databinding.ActivityNewsBinding
import com.example.newssite.db.ArticleDAO
import com.example.newssite.db.articleDatabase
import com.example.newssite.models.Article
import com.example.newssite.repository.NewsRepository

class NewsActivity : AppCompatActivity() {

    lateinit var newsViewModel: NewsViewModel
    lateinit var binding: ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

       // val viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)

        //newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)

        val newsRepository = NewsRepository(articleDatabase(this))

        val provider = NewsViewModelProviderFactory(newsRepository)

        newsViewModel = ViewModelProvider(this, provider)[NewsViewModel::class.java]


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)
        }
    }
