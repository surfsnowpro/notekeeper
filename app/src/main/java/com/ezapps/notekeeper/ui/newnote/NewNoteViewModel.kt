package com.ezapps.notekeeper.ui.newnote

import androidx.lifecycle.ViewModel
import com.ezapps.notekeeper.model.Note
import com.ezapps.notekeeper.repository.NoteRepo
import org.koin.core.KoinComponent

class NewNoteViewModel(private val noteRepo: NoteRepo): ViewModel(), KoinComponent {

    fun getNewNote(): Note = noteRepo.createNote()

    fun saveNote(note: Note, callback: ((id: Long?) -> Unit)?) {
        noteRepo.addNote(note, callback)
    }
}