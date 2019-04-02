package com.ezapps.notekeeper.ui.newnote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.ezapps.notekeeper.R
import com.ezapps.notekeeper.model.Note
import kotlinx.android.synthetic.main.fragment_new_note.*
import kotlinx.android.synthetic.main.list_item_note.*

class NewNoteFragment: Fragment() {

    private lateinit var viewModel: NewNoteViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_new_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NewNoteViewModel::class.java)

        //TODO: Add note validation
        btnSaveNote.setOnClickListener {
            viewModel.saveNote(buildNote())?.let { findNavController().navigate(R.id.action_global_noteListFragment) }
        }
    }

    private fun buildNote(): Note {
        val note = viewModel.getNewNote()
        note.title = tvNoteTitle.text.toString()
        note.text = tvNoteText.text.toString()
        return note
    }
}