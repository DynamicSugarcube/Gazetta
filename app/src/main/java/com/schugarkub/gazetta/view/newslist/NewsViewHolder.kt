/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.view.newslist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.schugarkub.gazetta.R
import com.schugarkub.gazetta.model.entity.Article
import com.schugarkub.gazetta.view.newsdetails.NewsDetailsActivity
import timber.log.Timber

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val context = itemView.context

    private val title: TextView = itemView.findViewById(R.id.news_item_title)
    private val author: TextView = itemView.findViewById(R.id.news_item_author)
    private val date: TextView = itemView.findViewById(R.id.news_item_date)
    private val image: ImageView = itemView.findViewById(R.id.news_item_image)
    private val seeDetailsButton: Button = itemView.findViewById(R.id.see_details_button)

    fun bind(article: Article) {
        title.setTextOrMakeGone(article.title)
        author.setTextOrMakeGone(article.author)
        date.setTextOrMakeGone(article.date)
        image.setImageUrlOrMakeGone(article.imageUrl)

        seeDetailsButton.setOnClickListener {
            if (article.url.isNullOrBlank()) {
                Timber.w("No URL provided!")
            } else {
                val intent = Intent(context, NewsDetailsActivity::class.java).apply {
                    putExtra(NewsDetailsActivity.EXTRA_URL, article.url)
                }
                context.startActivity(intent)
            }
        }
    }

    private fun TextView.setTextOrMakeGone(textString: String?) {
        if (textString.isNullOrBlank()) {
            visibility = View.GONE
        } else {
            text = textString
        }
    }

    private fun ImageView.setImageUrlOrMakeGone(url: String?) {
        if (url.isNullOrBlank()) {
            visibility = View.GONE
        } else {
            Glide.with(context).load(url).into(this)
        }
    }

    companion object {
        fun create(parent: ViewGroup): NewsViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
            return NewsViewHolder(view)
        }
    }
}