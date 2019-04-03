package com.ezapps.notekeeper.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ezapps.notekeeper.model.Note

@Database(entities = arrayOf(Note::class), version = 3)
abstract class NotekeeperDatabase: RoomDatabase() {

    companion object {
        private var instance: NotekeeperDatabase? = null

        fun getInstance(context: Context): NotekeeperDatabase {
            if (instance == null) {
                synchronized(NotekeeperDatabase::class.java) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NotekeeperDatabase::class.java,
                        "Notekeeper")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            return instance as NotekeeperDatabase
        }
    }

    abstract fun noteDao(): NoteDao
}