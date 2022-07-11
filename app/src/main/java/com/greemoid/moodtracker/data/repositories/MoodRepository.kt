package com.greemoid.moodtracker.data.repositories

import androidx.lifecycle.LiveData
import com.greemoid.moodtracker.models.Mood

interface MoodRepository {

    val allMoods: LiveData<List<Mood>>

    suspend fun addMood(mood: Mood, onSuccess:() -> Unit)
}