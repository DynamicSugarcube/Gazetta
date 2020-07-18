/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.schugarkub.gazetta.model.domain.Article

const val DATABASE_NAME = "articles_table"

@Entity(tableName = DATABASE_NAME)
data class DatabaseArticle(
    @PrimaryKey
    val url: String,
    val title: String?,
    val author: String?,
    val date: String?,
    val imageUrl: String?
) {

    fun toDomainArticle(): Article =
        Article(
            url = this.url,
            title = this.title,
            author = this.author,
            date = this.date,
            imageUrl = this.imageUrl
        )

    companion object Utils {

        fun List<DatabaseArticle>.toDomainArticles(): List<Article> = map { it.toDomainArticle() }
    }
}