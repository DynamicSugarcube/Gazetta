/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.model.networking

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface NewsApiService {

    @GET("top-headlines?country=us")
    fun getNewsFeedAsync(): Deferred<NewsApiResponse>
}