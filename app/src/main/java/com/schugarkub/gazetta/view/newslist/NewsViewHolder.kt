/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.view.newslist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.schugarkub.gazetta.R
import com.schugarkub.gazetta.model.entity.Article
import com.schugarkub.gazetta.view.newsdetails.NewsDetailsActivity
import timber.log.Timber

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val  context = itemView.context

    private val title: TextView = itemView.findViewById(R.id.news_item_title)
    private val author: TextView = itemView.findViewById(R.id.news_item_author)
    private val date: TextView = itemView.findViewById(R.id.news_item_date)

    private val seeDetailsButton: Button = itemView.findViewById(R.id.see_details_button)

    fun bind(article: Article) {
        title.text = article.title
        author.text = article.author
        date.text = article.date

        seeDetailsButton.setOnClickListener {
            Timber.d("Article URL: %s", article.url)
            val intent = Intent(context, NewsDetailsActivity::class.java).apply {
                putExtra(NewsDetailsActivity.EXTRA_URL, article.url)
            }
            context.startActivity(intent)
        }
    }

    companion object {
        fun create(parent: ViewGroup): NewsViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
            return NewsViewHolder(view)
        }
    }
}