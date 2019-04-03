package com.ezapps.notekeeper.di

import com.ezapps.notekeeper.ui.newnote.NewNoteViewModel
import com.ezapps.notekeeper.ui.notelist.NoteListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { NoteListViewModel(get())  }
    viewModel { NewNoteViewModel(get()) }
}