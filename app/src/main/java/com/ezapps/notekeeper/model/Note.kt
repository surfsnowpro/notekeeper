package com.ezapps.notekeeper.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.DateFormat
import java.util.*

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true) 
    var id: Long? = null,
    var title: String = "",
    var text: String = "",
    @ColumnInfo(name = "date_created")
    var dateCreated: String = DateFormat.getDateInstance(DateFormat.LONG).format(Date()),
    @ColumnInfo(name = "date_modified")
    var dateModified: String = DateFormat.getDateInstance(DateFormat.LONG).format(Date()),
    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean = false
)