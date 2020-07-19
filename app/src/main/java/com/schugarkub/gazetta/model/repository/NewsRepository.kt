/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.schugarkub.gazetta.model.database.ArticlesDatabase
import com.schugarkub.gazetta.model.database.DatabaseArticle.Utils.toDomainArticles
import com.schugarkub.gazetta.model.domain.Article
import com.schugarkub.gazetta.model.network.NetworkArticle
import com.schugarkub.gazetta.model.network.NetworkArticle.Utils.toDatabaseArticles
import com.schugarkub.gazetta.model.network.NewsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.io.IOException

class NewsRepository(private val database: ArticlesDatabase) {

    val articles: LiveData<List<Article>> = Transformations.map(database.dao.getArticles()) {
        it.toDomainArticles()
    }

    suspend fun refreshNewsFeed() = withContext(Dispatchers.IO) {
        val networkArticles = getArticlesOverNetwork()
        networkArticles?.let { cacheArticles(networkArticles) }
    }

    private suspend fun getArticlesOverNetwork(): List<NetworkArticle>? =
        withContext(Dispatchers.IO) {
            return@withContext try {
                NewsApi.retrofitService.getNewsFeedAsync().await().articles
            } catch (exception: IOException) {
                Timber.w(exception, "Couldn't get news feed over network.")
                null
            }
        }

    private suspend fun cacheArticles(networkArticles: List<NetworkArticle>) =
        withContext(Dispatchers.IO) {
            database.dao.insertArticles(networkArticles.toDatabaseArticles())
        }
}