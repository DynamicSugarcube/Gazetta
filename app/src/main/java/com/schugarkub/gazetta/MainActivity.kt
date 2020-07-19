/*
 * Copyright (c) 2020. Schugarkub
 */
package com.schugarkub.gazetta

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.schugarkub.gazetta.view.newslist.NewsListFragment
import com.schugarkub.gazetta.view.newstabs.NewsTabsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buildFragment(R.id.news_tabs_container, NewsTabsFragment::class.java)
        buildFragment(R.id.news_feed_container, NewsListFragment::class.java)
    }

    private fun <T: Fragment> buildFragment(fragmentId: Int, fragmentClass: Class<T>) {
        var fragment = supportFragmentManager.findFragmentById(fragmentId)
        if (fragment == null) {
            fragment = fragmentClass.newInstance()
            supportFragmentManager.beginTransaction()
                .add(fragmentId, fragment)
                .commit()
        }
    }
}
