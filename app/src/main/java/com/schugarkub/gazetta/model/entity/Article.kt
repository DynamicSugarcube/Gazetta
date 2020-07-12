/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.model.entity

import com.squareup.moshi.Json

data class Article(
    @Json(name = "title") val title: String?,
    @Json(name = "author") val author: String?,
    @Json(name = "publishedAt") val date: String?,
    @Json(name = "urlToImage") val imageUrl: String?,
    @Json(name = "url") val url: String?
)