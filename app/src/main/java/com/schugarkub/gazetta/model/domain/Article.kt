/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.model.domain

data class Article(
    val url: String,
    val title: String?,
    val author: String?,
    val date: String?,
    val imageUrl: String?
)