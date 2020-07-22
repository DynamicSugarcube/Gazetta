/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.model.database

import com.schugarkub.gazetta.model.domain.Article.Category
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

internal class CategoryConverterTest {

    private val converter = CategoryConverter()

    @Test
    fun convertCategory() {
        val category = Category.GENERAL

        val string = converter.convertArticleCategoryToString(category)

        assertEquals(category.value, string)
    }

    @Test
    fun convertLegalString() {
        val legalString = Category.HEALTH.value

        val category = converter.convertStringToArticleCategory(legalString)

        assertEquals(Category.HEALTH, category)
    }

    @Test
    fun convertIllegalString() {
        val illegalString = "illegalString"

        val exception = assertThrows(IllegalArgumentException::class.java) {
            converter.convertStringToArticleCategory(illegalString)
        }

        assertEquals("Couldn't convert string to article category.", exception.message)
    }
}