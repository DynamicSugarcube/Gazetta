/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.view.newslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.schugarkub.gazetta.R
import com.schugarkub.gazetta.model.entity.Article
import com.schugarkub.gazetta.viewmodel.newslist.NewsListViewModel
import com.schugarkub.gazetta.viewmodel.newslist.NewsListViewModelFactory

class NewsListFragment : Fragment() {

    private lateinit var newsRecyclerView: RecyclerView

    private lateinit var newsListViewModel: NewsListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val newsListViewModelFactory = NewsListViewModelFactory()
        newsListViewModel = ViewModelProvider(this, newsListViewModelFactory)
            .get(NewsListViewModel::class.java)

        newsListViewModel.articlesLiveData.observe(
            this, Observer { articles -> setupRecyclerView(articles) }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news_list, container, false)

        val newsLayoutManager = LinearLayoutManager(context)
        newsRecyclerView = view.findViewById<RecyclerView>(R.id.news_recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = newsLayoutManager
        }

        return view
    }

    private fun setupRecyclerView(articles: List<Article>) {
        val newsAdapter = NewsAdapter(articles)
        newsRecyclerView.adapter = newsAdapter
    }
}
