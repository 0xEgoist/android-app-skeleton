package com.example.apptemplate

import android.app.Application
import android.webkit.WebView
import com.example.apptemplate.di.ApplicationComponent
import com.example.apptemplate.di.DaggerApplicationComponent
import com.facebook.stetho.Stetho

class App : Application() {

    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()

        // Stetho
        Stetho.initializeWithDefaults(this)
        WebView.setWebContentsDebuggingEnabled(true)
    }
}
