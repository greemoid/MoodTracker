package com.greemoid.moodtracker.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.greemoid.moodtracker.models.Mood

@Dao
interface MoodDao {

    @Query("SELECT * FROM mood_table")
    fun getAllMoods() : LiveData<List<Mood>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMood(mood: Mood)

}