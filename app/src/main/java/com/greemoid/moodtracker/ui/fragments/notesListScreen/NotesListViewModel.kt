package com.greemoid.moodtracker.ui.fragments.notesListScreen


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.greemoid.moodtracker.models.Note
import com.greemoid.moodtracker.utils.NOTE_REPOSITORY

class NotesListViewModel(): ViewModel() {

    fun getAllNotes() : LiveData<List<Note>> = NOTE_REPOSITORY.allNotes


}