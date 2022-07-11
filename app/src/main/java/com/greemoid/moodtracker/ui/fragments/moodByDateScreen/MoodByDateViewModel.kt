package com.greemoid.moodtracker.ui.fragments.moodByDateScreen

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.greemoid.moodtracker.data.db.MoodDatabase
import com.greemoid.moodtracker.data.repositories.MoodRealization
import com.greemoid.moodtracker.models.Mood
import com.greemoid.moodtracker.utils.MOOD_REPOSITORY

class MoodByDateViewModel() : ViewModel() {

    fun getAllMoods() : LiveData<List<Mood>> = MOOD_REPOSITORY.allMoods

}