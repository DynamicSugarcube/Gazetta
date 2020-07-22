/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.model.database

import com.schugarkub.gazetta.model.domain.Article.Country
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

internal class CountryConverterTest {

    private val converter = CountryConverter()

    @Test
    fun convertCountry() {
        val country = Country.RUSSIA

        val string = converter.convertArticleCountryToString(country)

        assertEquals(country.value, string)
    }

    @Test
    fun convertLegalString() {
        val legalString = Country.USA.value

        val country = converter.convertStringToArticleCountry(legalString)

        assertEquals(Country.USA, country)
    }

    @Test
    fun convertIllegalString() {
        val illegalString = "illegalString"

        val exception = assertThrows(IllegalArgumentException::class.java) {
            converter.convertStringToArticleCountry(illegalString)
        }

        assertEquals("Couldn't convert string to article country.", exception.message)
    }
}