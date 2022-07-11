package com.greemoid.moodtracker.ui.fragments.noteScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greemoid.moodtracker.models.Note
import com.greemoid.moodtracker.utils.NOTE_REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel() : ViewModel() {

    fun updateNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        NOTE_REPOSITORY.updateNote(note){}
    }


    fun deleteNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        NOTE_REPOSITORY.deleteNote(note){}
    }
}