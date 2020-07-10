/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.schugarkub.gazetta.R

class NewsListFragment : Fragment() {

    private lateinit var newsRecyclerView: RecyclerView
    private lateinit var newsAdapter: RecyclerView.Adapter<*>
    private lateinit var newsLayoutManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news_list, container, false)

        newsAdapter = NewsAdapter()
        newsLayoutManager = LinearLayoutManager(context)

        newsRecyclerView = view.findViewById<RecyclerView>(R.id.news_recycler_view).apply {
            setHasFixedSize(true)
            adapter = newsAdapter
            layoutManager = newsLayoutManager
        }

        return view
    }
}
