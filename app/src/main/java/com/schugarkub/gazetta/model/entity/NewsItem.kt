/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.model.entity

import java.util.Date

data class NewsItem(
    val title: String,
    val author: String,
    val date: Date,
    val imageUrl: String,
    val url: String
)