package com.aplikasi.mcc

import android.app.Application
import android.content.Context

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this

        appContext = applicationContext

    }

    companion object {
        lateinit var instance: App

        private lateinit var appContext : Context
        val context: Context
            get() = appContext
    }
}