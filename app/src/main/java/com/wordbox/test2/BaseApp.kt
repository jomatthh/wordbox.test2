package com.wordbox.test2

import android.app.Application
import com.wordbox.test2.di.KoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@BaseApp)
            KoinModules.init()
        }
    }
}