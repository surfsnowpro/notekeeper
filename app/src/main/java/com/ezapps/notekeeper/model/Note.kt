package com.ezapps.notekeeper.model

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
    var dateCreated: String = DateFormat.getDateInstance(DateFormat.LONG).format(Date()),
    var dateModified: String? = null,
    var isFavorite: Boolean = false
)