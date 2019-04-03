package com.ezapps.notekeeper.ui.notelist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ezapps.notekeeper.model.Note
import com.ezapps.notekeeper.repository.NoteRepo
import org.koin.core.KoinComponent

class NoteListViewModel(private val noteRepo: NoteRepo): ViewModel(), KoinComponent {
    companion object {
        const val TAG = "NoteListViewModel"
    }

    fun loadAllNotes(): LiveData<List<Note>> {
        return noteRepo.allNotes
    }

    fun onNoteClicked(note: Note) {
        Log.d(TAG, "Selected Note: ${note.title}")
    }
}