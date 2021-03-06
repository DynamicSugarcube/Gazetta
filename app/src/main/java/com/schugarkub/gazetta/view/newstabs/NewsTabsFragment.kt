/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.view.newstabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.schugarkub.gazetta.R

class NewsTabsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news_tabs, container, false)
    }
}