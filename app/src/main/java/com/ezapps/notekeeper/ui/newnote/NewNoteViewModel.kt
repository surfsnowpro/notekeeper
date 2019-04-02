package com.ezapps.notekeeper.ui.newnote

import androidx.lifecycle.ViewModel
import com.ezapps.notekeeper.NotekeeperApplication
import com.ezapps.notekeeper.model.Note
import com.ezapps.notekeeper.repository.NoteRepo

class NewNoteViewModel: ViewModel() {

    private var noteRepo = NoteRepo(NotekeeperApplication.instance)

    fun getNewNote(): Note = noteRepo.createNote()

    fun saveNote(note: Note): Long? {
        return noteRepo.addNote(note)
    }
}