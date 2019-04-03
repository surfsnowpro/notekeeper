package com.ezapps.notekeeper.db

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.OnConflictStrategy.REPLACE
import com.ezapps.notekeeper.base.db.BaseDao
import com.ezapps.notekeeper.model.Note

@Dao
interface NoteDao: BaseDao<Note> {

    @Query("SELECT * FROM Note")
    fun loadAll(): LiveData<List<Note>>

    @Query("SELECT * FROM Note WHERE id = :noteId")
    fun loadNote(noteId: Long): LiveData<Note>

//    @Insert(onConflict = IGNORE)
//    fun insertNote(note: Note): Long
//
//    @Delete
//    fun deleteNote(note: Note)
//
//    @Update(onConflict = REPLACE)
//    fun updateNote(note: Note)
}