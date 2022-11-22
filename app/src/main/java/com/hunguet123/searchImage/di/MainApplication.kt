package com.hunguet123.searchImage.di

import android.app.Application
import com.hunguet123.searchImage.data.di.networkModule
import com.hunguet123.searchImage.data.di.repositoryModule
import com.hunguet123.searchImage.data.di.roomModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application (){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@MainApplication)
            // Load modules
            modules(viewModelModule, networkModule, repositoryModule, roomModule)
        }
    }
}
