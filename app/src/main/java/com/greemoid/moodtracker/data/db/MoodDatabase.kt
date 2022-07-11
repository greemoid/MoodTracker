package com.greemoid.moodtracker.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.greemoid.moodtracker.data.db.dao.MoodDao
import com.greemoid.moodtracker.models.Mood

@Database(entities = [Mood::class], version = 2)
abstract class MoodDatabase : RoomDatabase() {


    abstract fun getMoodDao(): MoodDao

    companion object {

        private var database: MoodDatabase? = null

        @Synchronized
        fun getInstance(context: Context): MoodDatabase {
            return if (database == null) {
                database = Room.databaseBuilder(
                    context,
                    MoodDatabase::class.java,
                    "mood_table.db")
                    .fallbackToDestructiveMigration()
                    .build()
                database as MoodDatabase
            } else {
                database as MoodDatabase
            }
        }
    }
}