package com.greemoid.moodtracker.data.repositories

import androidx.lifecycle.LiveData
import com.greemoid.moodtracker.models.Note

interface NoteRepository {

    val allNotes : LiveData<List<Note>>

    suspend fun insertNote(note: Note, onSuccess: () -> Unit)

    suspend fun deleteNote(note: Note, onSuccess: () -> Unit)

    suspend fun updateNote(note: Note, onSuccess: () -> Unit)
}