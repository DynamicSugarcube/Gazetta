/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.view.newslist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.schugarkub.gazetta.R
import com.schugarkub.gazetta.model.NewsItem
import com.schugarkub.gazetta.view.newsdetails.NewsDetailsActivity

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val  context = itemView.context

    private val title: TextView = itemView.findViewById(R.id.news_item_title)
    private val author: TextView = itemView.findViewById(R.id.news_item_author)
    private val date: TextView = itemView.findViewById(R.id.news_item_date)

    fun bind(newsItem: NewsItem) {
        title.text = newsItem.title
        author.text = newsItem.author
        date.text = newsItem.date.toString()

        title.setOnClickListener {
            val intent = Intent(context, NewsDetailsActivity::class.java).apply {
                putExtra(NewsDetailsActivity.EXTRA_URL, TEST_URL)
            }
            context.startActivity(intent)
        }
    }

    companion object {
        private const val TEST_URL = "https://ru.wikipedia.org/"

        fun create(parent: ViewGroup): NewsViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
            return NewsViewHolder(view)
        }
    }
}