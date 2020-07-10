/*
 * Copyright (c) 2020. Schugarkub
 */
package com.schugarkub.gazetta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.schugarkub.gazetta.view.newslist.NewsListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager

        var fragment = fragmentManager.findFragmentById(R.id.fragment_container)
        if (fragment == null) {
            fragment = NewsListFragment()
            fragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit()
        }
    }
}
