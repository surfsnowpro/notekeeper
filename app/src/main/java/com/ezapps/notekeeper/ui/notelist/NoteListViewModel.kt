package com.ezapps.notekeeper.ui.notelist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ezapps.notekeeper.NotekeeperApplication
import com.ezapps.notekeeper.model.Note
import com.ezapps.notekeeper.repository.NoteRepo

class NoteListViewModel: ViewModel() {
    companion object {
        const val TAG = "NoteListViewModel"
    }

    private var noteRepo = NoteRepo(NotekeeperApplication.instance)

    fun loadAllNotes(): LiveData<List<Note>> {
        return noteRepo.allNotes
    }

    fun onNoteClicked(note: Note) {
        Log.d(TAG, "Selected Note: ${note.title}")
    }
}