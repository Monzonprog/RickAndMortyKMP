package com.jmonzonm.rickmortyapp

import android.app.Application
import com.jmonzonm.rickmortyapp.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger

class RickMortyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            AndroidLogger()
            androidContext(this@RickMortyApp)
        }
    }
}