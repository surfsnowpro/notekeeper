package com.ezapps.notekeeper.ui

import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    // Inflate different menus based on the View being shown
    var menuResourceId: Int? = null
    var menuClickAction: ((id: Int) -> Unit)? = null
}