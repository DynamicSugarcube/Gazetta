/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.schugarkub.gazetta.R
import com.schugarkub.gazetta.model.NewsItem

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title: TextView = itemView.findViewById(R.id.news_item_title)
    private val author: TextView = itemView.findViewById(R.id.news_item_author)
    private val date: TextView = itemView.findViewById(R.id.news_item_date)

    fun bind(newsItem: NewsItem) {
        title.text = newsItem.title
        author.text = newsItem.author
        date.text = newsItem.date.toString()
    }

    companion object {
        fun create(parent: ViewGroup): NewsViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
            return NewsViewHolder(view)
        }
    }
}