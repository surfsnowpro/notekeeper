package com.ezapps.notekeeper

import android.app.Application
import com.ezapps.notekeeper.di.appModule
import com.ezapps.notekeeper.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class NotekeeperApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@NotekeeperApplication)
            androidLogger()
            modules(appModule, viewModelModule)
        }
    }
}