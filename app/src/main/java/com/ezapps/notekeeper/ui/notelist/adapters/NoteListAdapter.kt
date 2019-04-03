package com.ezapps.notekeeper.ui.notelist.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.ezapps.notekeeper.base.adapters.BaseImmutableAdapter
import com.ezapps.notekeeper.databinding.ListItemNoteBinding
import com.ezapps.notekeeper.model.Note
import com.ezapps.notekeeper.ui.notelist.NoteListViewModel

class NoteListAdapter(private val viewModel: NoteListViewModel): BaseImmutableAdapter<Note, NoteListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteListViewHolder {
        val binding = ListItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.viewModel = viewModel
        return NoteListViewHolder(binding)
    }
}