package com.ezapps.notekeeper

import android.app.Application

class NotekeeperApplication: Application() {

    companion object {
        lateinit var instance: NotekeeperApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}