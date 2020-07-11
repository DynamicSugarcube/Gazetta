/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.model.networking

import com.schugarkub.gazetta.model.entity.Article
import com.squareup.moshi.Json

data class NewsApiResponse(
    @Json(name = "articles") val articles: List<Article>
)