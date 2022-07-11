package com.greemoid.moodtracker.ui.fragments.addNoteScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greemoid.moodtracker.data.repositories.NoteRepository
import com.greemoid.moodtracker.models.Note
import com.greemoid.moodtracker.utils.NOTE_REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel : ViewModel() {

    fun insert(note: Note, onSuccess:() -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            NOTE_REPOSITORY.insertNote(note){}
        }
}