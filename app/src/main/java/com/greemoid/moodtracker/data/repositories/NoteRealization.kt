package com.greemoid.moodtracker.data.repositories

import androidx.lifecycle.LiveData
import com.greemoid.moodtracker.data.db.dao.NotesDao
import com.greemoid.moodtracker.models.Note

class NoteRealization(private val notesDao: NotesDao) : NoteRepository {



    override val allNotes: LiveData<List<Note>>
        get() = notesDao.getAllNotes()



    override suspend fun insertNote(note: Note, onSuccess: () -> Unit) {
        notesDao.insertNote(note)
        onSuccess()
    }




    override suspend fun deleteNote(note: Note, onSuccess: () -> Unit) {
        notesDao.deleteNote(note)
        onSuccess()
    }

    override suspend fun updateNote(note: Note, onSuccess: () -> Unit) {
        notesDao.updateNote(note)
        onSuccess()
    }
}