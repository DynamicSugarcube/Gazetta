/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.view.newslist

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.schugarkub.gazetta.model.entity.Article

class NewsAdapter(private val articles: List<Article>) : RecyclerView.Adapter<NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder =
        NewsViewHolder.create(parent)

    override fun getItemCount(): Int = articles.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) =
        holder.bind(articles[position])
}