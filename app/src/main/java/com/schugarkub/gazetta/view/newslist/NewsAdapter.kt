/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.view.newslist

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.schugarkub.gazetta.model.NewsItem
import java.util.*

class NewsAdapter : RecyclerView.Adapter<NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder =
        NewsViewHolder.create(parent)

    override fun getItemCount(): Int = NEWS_FEED.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) =
        holder.bind(NEWS_FEED[position])

    companion object {
        private const val NEWS_NUMBER = 50
        private val NEWS_FEED = List(NEWS_NUMBER) { index ->
            NewsItem(
                title = "News Title $index",
                author = "Journalist $index",
                date = Date(),
                imageUrl = "",
                url = ""
            )
        }
    }
}