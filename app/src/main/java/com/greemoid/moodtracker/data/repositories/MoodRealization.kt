package com.greemoid.moodtracker.data.repositories

import androidx.lifecycle.LiveData
import com.greemoid.moodtracker.data.db.dao.MoodDao
import com.greemoid.moodtracker.models.Mood

class MoodRealization(private val moodDao: MoodDao) : MoodRepository {

    override val allMoods: LiveData<List<Mood>>
        get() = moodDao.getAllMoods()

    override suspend fun addMood(mood: Mood, onSuccess: () -> Unit) {
        moodDao.addMood(mood)
        onSuccess()
    }
}