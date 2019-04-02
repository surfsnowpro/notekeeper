package com.ezapps.notekeeper.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.ezapps.notekeeper.db.NotekeeperDatabase
import com.ezapps.notekeeper.model.Note

class NoteRepo(private val context: Context) {

    private var db = NotekeeperDatabase.getInstance(context)
    private var noteDao = db.noteDao()

    val allNotes: LiveData<List<Note>>
        get() {
            return noteDao.loadAll()
        }

    fun createNote(): Note {
        return Note()
    }

    fun addNote(note: Note): Long? {
        return noteDao.insertNote(note)
    }

    fun updateNote(note: Note) {
        noteDao.updateNote(note)
    }
}