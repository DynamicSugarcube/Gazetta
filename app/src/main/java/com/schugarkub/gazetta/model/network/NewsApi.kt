/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.model.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.schugarkub.gazetta.BuildConfig
import com.schugarkub.gazetta.model.entity.Article
import com.schugarkub.gazetta.model.entity.NetworkArticle
import com.squareup.moshi.Json
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NewsApi {

    val retrofitService: NewsApiService by lazy {
        retrofit.create(NewsApiService::class.java)
    }

    private val retrofit: Retrofit
        get() = Retrofit.Builder()
            .baseUrl(NEWS_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

    private val moshi: Moshi
        get() = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

    private val okHttpClient: OkHttpClient
        get() = OkHttpClient().newBuilder()
            .addInterceptor(authInterceptor)
            .build()

    private val authInterceptor = Interceptor { chain ->
        val url = chain.request().url().newBuilder()
            .addQueryParameter(API_KEY_PARAMETER, BuildConfig.NEWS_API_KEY)
            .build()

        val request = chain.request().newBuilder()
            .url(url)
            .build()

        chain.proceed(request)
    }

    private const val NEWS_BASE_URL = "https://newsapi.org/v2/"
    private const val API_KEY_PARAMETER = "apiKey"
}

data class NewsApiResponse(
    @Json(name = "articles") val articles: List<NetworkArticle>
)