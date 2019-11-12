package com.omurkmr.githubrepo

import android.app.Application
import com.omurkmr.githubrepo.koin.configuration
import com.omurkmr.githubrepo.koin.dataSourceModule
import com.omurkmr.githubrepo.koin.remoteDataSourceModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application(){

    override fun onCreate() {
        super.onCreate()

        insertKoin()
    }

    private fun insertKoin() {
        startKoin {
            androidContext(this@App)
            modules(
                configuration,
                remoteDataSourceModule,
                dataSourceModule
            )
        }
    }
}