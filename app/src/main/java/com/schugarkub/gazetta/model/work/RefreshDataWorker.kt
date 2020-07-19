/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.model.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.schugarkub.gazetta.model.database.ArticlesDatabase
import com.schugarkub.gazetta.model.repository.NewsRepository
import retrofit2.HttpException

class RefreshDataWorker(appContext: Context, params: WorkerParameters) :
    CoroutineWorker(appContext, params) {

    override suspend fun doWork(): Result {
        val database = ArticlesDatabase.getDatabaseInstance(applicationContext)
        val repository = NewsRepository(database)

        try {
            repository.refreshNewsFeed()
        } catch (exception: HttpException) {
            return Result.retry()
        }

        return Result.success()
    }

    companion object {

        const val WORK_NAME = "com.schugarkub.gazetta.model.work.RefreshDataWorker"
    }
}