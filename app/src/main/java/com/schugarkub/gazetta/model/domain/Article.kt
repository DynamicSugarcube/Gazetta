/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.model.domain

data class Article(
    val url: String,
    val title: String?,
    val author: String?,
    val date: String?,
    val imageUrl: String?,
    val category: Category = Category.BUSINESS,
    val country: Country = Country.RUSSIA
) {

    enum class Category(val value: String) {
        BUSINESS("business"),
        ENTERTAINMENT("entertainment"),
        GENERAL("general"),
        HEALTH("health"),
        SCIENCE("science"),
        SPORTS("sports"),
        TECHNOLOGY("technology")
    }

    enum class Country(val value: String) {
        USA("us"),
        GREAT_BRITAIN("gb"),
        GERMANY("de"),
        FRANCE("fr"),
        RUSSIA("ru")
    }
}