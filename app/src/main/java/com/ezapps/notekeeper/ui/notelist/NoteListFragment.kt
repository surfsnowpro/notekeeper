package com.ezapps.notekeeper.ui.notelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.ezapps.notekeeper.R
import kotlinx.android.synthetic.main.fragment_note_list.*

class NoteListFragment: Fragment() {

    private lateinit var viewModel: NoteListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_note_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NoteListViewModel::class.java)
        fabNewNote.setOnClickListener { findNavController().navigate(R.id.action_noteListFragment_to_addNoteFragment) }
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadAllNotes().observe(this, Observer { rvNotes })
    }

    private fun setupAdapter() {

    }
}