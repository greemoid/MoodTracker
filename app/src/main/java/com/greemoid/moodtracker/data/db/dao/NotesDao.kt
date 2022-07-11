package com.greemoid.moodtracker.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.greemoid.moodtracker.models.Note

@Dao
interface NotesDao {

    @Query("SELECT * FROM diary_table")
    fun getAllNotes(): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}