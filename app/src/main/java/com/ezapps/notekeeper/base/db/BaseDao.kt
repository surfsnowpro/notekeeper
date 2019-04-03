package com.ezapps.notekeeper.base.db

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Update

interface BaseDao<T> {

    @Insert(onConflict = IGNORE)
    fun insert(obj: T): Long

    @Update(onConflict = REPLACE)
    fun update(obj: T)

    @Delete
    fun delete(obj: T)
}