/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.model.entity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = false)
data class NetworkArticle(
    val url: String?,
    val title: String?,
    val author: String?,
    val publishedAt: String?,
    val urlToImage: String?
)

fun List<NetworkArticle>.toDomainArticles(): List<Article> = map {
    Article(
        url = it.url,
        title = it.title,
        author = it.author,
        date = it.publishedAt,
        imageUrl = it.urlToImage
    )
}