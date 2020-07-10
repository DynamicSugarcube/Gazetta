/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.view.newsdetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.schugarkub.gazetta.R

class NewsDetailsActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)

        webView = findViewById(R.id.details_web_view)
        webView.webViewClient = DetailsWebClient()

        val url = intent.getStringExtra(EXTRA_URL)
        webView.loadUrl(url)
    }

    override fun onBackPressed() = when (webView.canGoBack()) {
        true -> webView.goBack()
        false -> super.onBackPressed()
    }

    private class DetailsWebClient : WebViewClient() {

        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            view?.loadUrl(request?.url.toString())
            return true
        }
    }

    companion object {
        const val EXTRA_URL = "url"
    }
}
