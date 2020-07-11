/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta

import android.app.Application
import timber.log.Timber

class GazettaApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}