/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.viewmodel.newslist

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NewsListViewModelFactory(private val application: Application) :
    ViewModelProvider.AndroidViewModelFactory(application) {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when {
        modelClass.isAssignableFrom(NewsListViewModel::class.java) ->
            NewsListViewModel(application) as T
        else -> throw IllegalArgumentException("Unknown ViewModel class")
    }
}