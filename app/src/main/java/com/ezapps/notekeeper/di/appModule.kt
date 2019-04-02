package com.ezapps.notekeeper.di

import com.ezapps.notekeeper.repository.NoteRepo
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module {

    single { NoteRepo(androidApplication())}
}