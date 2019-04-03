package com.ezapps.notekeeper.repository

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.ezapps.notekeeper.base.db.BaseDao
import com.ezapps.notekeeper.db.NoteDao
import com.ezapps.notekeeper.db.NotekeeperDatabase
import com.ezapps.notekeeper.model.Note

class NoteRepo(context: Context) {

    private var db = NotekeeperDatabase.getInstance(context)
    private var noteDao = db.noteDao()

    val allNotes: LiveData<List<Note>>
        get() {
            return noteDao.loadAll()
        }

    fun createNote(): Note {
        return Note()
    }

    fun addNote(note: Note, callback:((id: Long?) -> Unit)? = null){
        InsertAsyncTask(noteDao, callback).execute(note)
    }

    fun updateNote(note: Note) {
        noteDao.update(note)
    }

    companion object {
        class InsertAsyncTask(private val dao: NoteDao, private val callback: ((id: Long?) -> Unit)?)
            : AsyncTask<Note, Void, Long?>() {

            override fun doInBackground(vararg params: Note?): Long? {
                val note = params[0]
                note?.let { return dao.insert(it) } ?: return null
            }

            override fun onPostExecute(result: Long?) {
                callback?.invoke(result)
            }
        }
    }
}