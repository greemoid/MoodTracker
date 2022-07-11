package com.greemoid.moodtracker.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mood_table")
class Mood (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo val mood: String,
    @ColumnInfo val textOfMood: String,
    @ColumnInfo val date: String
        )