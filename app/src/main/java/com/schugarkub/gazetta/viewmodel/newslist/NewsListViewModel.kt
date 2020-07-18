/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.viewmodel.newslist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.schugarkub.gazetta.model.database.ArticlesDatabase
import com.schugarkub.gazetta.model.domain.Article
import com.schugarkub.gazetta.model.repository.NewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.IOException

class NewsListViewModel(application: Application) : AndroidViewModel(application) {

    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val newsRepository = NewsRepository(
        ArticlesDatabase.getDatabaseInstance(
            application.applicationContext
        )
    )

    private val _articlesLiveData by lazy { MutableLiveData<List<Article>>() }
    val articlesLiveData: LiveData<List<Article>>
        get() = _articlesLiveData

    init {
        refreshData()
    }

    private fun refreshData() = viewModelScope.launch {
        try {
            _articlesLiveData.value = newsRepository.refreshNewsFeed()
        } catch (networkException: IOException) {
            Timber.e(networkException, "Exception encountered while fetching news feed")
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}