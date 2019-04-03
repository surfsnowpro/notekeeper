package com.ezapps.notekeeper.ui.newnote

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.ezapps.notekeeper.R
import com.ezapps.notekeeper.model.Note
import kotlinx.android.synthetic.main.fragment_new_note.*
import org.koin.android.viewmodel.ext.android.viewModel

class NewNoteFragment: Fragment() {
    companion object {
        const val TAG = "NewNoteFragment"
    }

    private val newNoteViewModel: NewNoteViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_new_note, container, false)
    }

    private fun buildNote(): Note {
        val note = newNoteViewModel.getNewNote()
        note.title = etNoteTitle.text.toString()
        note.text = etNoteText.text.toString()
        return note
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.new_note_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_save -> {
                //TODO: Add note validation
                newNoteViewModel.saveNote(buildNote()) {
                    Log.d(TAG, "Saving note: $it")
                    it?.let { findNavController().navigate(R.id.action_global_noteListFragment) }
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}