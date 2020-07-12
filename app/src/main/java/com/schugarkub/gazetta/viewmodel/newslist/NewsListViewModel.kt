/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.viewmodel.newslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.schugarkub.gazetta.model.entity.Article
import com.schugarkub.gazetta.model.network.NewsApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber

class NewsListViewModel : ViewModel() {

    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _articlesLiveData by lazy { MutableLiveData<List<Article>>() }
    val articlesLiveData: LiveData<List<Article>>
        get() = _articlesLiveData

    init { getNewsFeed() }

    private fun getNewsFeed() = coroutineScope.launch {
        val newsResponseDeferred = NewsApi.retrofitService.getNewsFeedAsync()

        try {
            _articlesLiveData.value = newsResponseDeferred.await().articles
        } catch (exception: Exception) {
            Timber.e(exception, "Exception encountered while fetching news feed")
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}