/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.model.network

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface NewsApiService {

    @GET("top-headlines?country=ru")
    fun getNewsFeedAsync(): Deferred<NewsApiResponse>
}