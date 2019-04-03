package com.ezapps.notekeeper.ui.notelist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ezapps.notekeeper.R
import com.ezapps.notekeeper.ui.notelist.adapters.NoteListAdapter
import kotlinx.android.synthetic.main.fragment_note_list.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.KoinComponent

class NoteListFragment: Fragment(), KoinComponent {
    companion object {
        const val TAG = "NoteListFragment"
    }

    private val noteListViewModel: NoteListViewModel by viewModel()
    private lateinit var adapter: NoteListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_note_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fabNewNote.setOnClickListener { findNavController().navigate(R.id.action_noteListFragment_to_addNoteFragment) }

        setupAdapter()
    }

    override fun onResume() {
        Log.d(TAG, "onResume")
        super.onResume()
        noteListViewModel.loadAllNotes().observe(this, Observer {
            adapter.items = it
        })
    }

    private fun setupAdapter() {
        Log.d(TAG, "setting up adapter")
        adapter = NoteListAdapter(noteListViewModel)
        rvNotes.layoutManager = LinearLayoutManager(context)
        rvNotes.adapter = adapter
    }
}