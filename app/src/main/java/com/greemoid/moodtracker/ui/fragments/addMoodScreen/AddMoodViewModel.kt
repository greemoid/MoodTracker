package com.greemoid.moodtracker.ui.fragments.addMoodScreen

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greemoid.moodtracker.data.db.MoodDatabase
import com.greemoid.moodtracker.data.repositories.MoodRealization
import com.greemoid.moodtracker.models.Mood
import com.greemoid.moodtracker.utils.MOOD_REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddMoodViewModel(application: Application): AndroidViewModel(application) {

    private val context = application

    fun addMood(mood: Mood, onSuccess:() -> Unit) = viewModelScope.launch(Dispatchers.IO) {
        MOOD_REPOSITORY.addMood(mood){}
    }

}