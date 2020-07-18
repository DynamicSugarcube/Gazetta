/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.model.network

import com.schugarkub.gazetta.model.database.DatabaseArticle
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = false)
data class NetworkArticle(
    val url: String?,
    val title: String?,
    val author: String?,
    val publishedAt: String?,
    val urlToImage: String?
) {

    fun toDatabaseArticle(): DatabaseArticle? = when (url) {
        null -> null
        else -> DatabaseArticle(
            url = url,
            title = title,
            author = author,
            date = publishedAt,
            imageUrl = urlToImage
        )
    }

    companion object Utils {

        fun List<NetworkArticle>.toDatabaseArticles(): List<DatabaseArticle> =
            mapNotNull { it.toDatabaseArticle() }
    }
}