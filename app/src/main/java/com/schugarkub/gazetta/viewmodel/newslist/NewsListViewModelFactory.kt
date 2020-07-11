/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.viewmodel.newslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NewsListViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when {
        modelClass.isAssignableFrom(NewsListViewModel::class.java) -> NewsListViewModel() as T
        else -> throw IllegalArgumentException("Unknown ViewModel class")
    }
}