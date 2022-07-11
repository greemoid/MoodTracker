package com.greemoid.moodtracker.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.greemoid.moodtracker.data.db.dao.NotesDao
import com.greemoid.moodtracker.models.Note

@Database(entities = [Note::class], version = 3)
abstract class NotesDatabase: RoomDatabase() {

    abstract fun getNotesDao(): NotesDao

    companion object {

        private var database: NotesDatabase? = null

        @Synchronized
        fun getInstance(context: Context): NotesDatabase {
            return if (database == null) {
                database = Room.databaseBuilder(
                    context,
                    NotesDatabase::class.java,
                    "notes.db")
                    .fallbackToDestructiveMigration()
                    .build()
                database as NotesDatabase
            } else {
                database as NotesDatabase
            }
        }

    }
}