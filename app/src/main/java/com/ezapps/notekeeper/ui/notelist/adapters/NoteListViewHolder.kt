package com.ezapps.notekeeper.ui.notelist.adapters

import com.ezapps.notekeeper.base.adapters.BaseViewHolder
import com.ezapps.notekeeper.databinding.ListItemNoteBinding
import com.ezapps.notekeeper.model.Note

class NoteListViewHolder(private val binding: ListItemNoteBinding): BaseViewHolder<Note>(binding) {

    override fun onBind(item: Note) {
        binding.note = item
        binding.executePendingBindings()
    }
}