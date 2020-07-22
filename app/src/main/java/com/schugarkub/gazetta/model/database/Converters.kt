/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.model.database

import androidx.room.TypeConverter
import com.schugarkub.gazetta.model.domain.Article

class CategoryConverter {

    @TypeConverter
    fun convertArticleCategoryToString(category: Article.Category): String = category.value

    @TypeConverter
    fun convertStringToArticleCategory(string: String): Article.Category = when (string) {
        Article.Category.BUSINESS.value -> Article.Category.BUSINESS
        Article.Category.ENTERTAINMENT.value -> Article.Category.ENTERTAINMENT
        Article.Category.GENERAL.value -> Article.Category.GENERAL
        Article.Category.HEALTH.value -> Article.Category.HEALTH
        Article.Category.SCIENCE.value -> Article.Category.SPORTS
        Article.Category.SPORTS.value -> Article.Category.SPORTS
        Article.Category.TECHNOLOGY.value -> Article.Category.TECHNOLOGY
        else -> throw IllegalArgumentException("Couldn't convert string to article category.")
    }
}

class CountryConverter {

    @TypeConverter
    fun convertArticleCountryToString(country: Article.Country): String = country.value

    @TypeConverter
    fun convertStringToArticleCountry(string: String): Article.Country = when (string) {
        Article.Country.USA.value -> Article.Country.USA
        Article.Country.GREAT_BRITAIN.value -> Article.Country.GREAT_BRITAIN
        Article.Country.GERMANY.value -> Article.Country.GERMANY
        Article.Country.FRANCE.value -> Article.Country.FRANCE
        Article.Country.RUSSIA.value -> Article.Country.RUSSIA
        else -> throw IllegalArgumentException("Couldn't convert string to article country.")
    }
}