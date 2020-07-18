/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.view.newslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.schugarkub.gazetta.R
import com.schugarkub.gazetta.viewmodel.newslist.NewsListViewModel
import com.schugarkub.gazetta.viewmodel.newslist.NewsListViewModelFactory

class NewsListFragment : Fragment() {

    private lateinit var newsAdapter: NewsAdapter
    private lateinit var newsRecyclerView: RecyclerView

    private lateinit var newsListViewModel: NewsListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val newsListViewModelFactory = NewsListViewModelFactory(activity!!.application)
        newsListViewModel = ViewModelProvider(this, newsListViewModelFactory)
            .get(NewsListViewModel::class.java)

        newsListViewModel.articlesLiveData.observe(
            this, Observer { articles -> newsAdapter.articles = articles }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news_list, container, false)

        val newsLayoutManager = LinearLayoutManager(context)
        newsAdapter = NewsAdapter()
        newsRecyclerView = view.findViewById<RecyclerView>(R.id.news_recycler_view).apply {
            setHasFixedSize(true)
            adapter = newsAdapter
            layoutManager = newsLayoutManager
        }

        return view
    }
}
