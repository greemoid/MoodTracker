package com.greemoid.moodtracker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.greemoid.moodtracker.R
import com.greemoid.moodtracker.databinding.ActivityMainBinding
import com.greemoid.moodtracker.data.db.MoodDatabase
import com.greemoid.moodtracker.data.db.NotesDatabase
import com.greemoid.moodtracker.data.repositories.MoodRealization
import com.greemoid.moodtracker.data.repositories.NoteRealization
import com.greemoid.moodtracker.utils.MOOD_REPOSITORY
import com.greemoid.moodtracker.utils.NOTE_REPOSITORY

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        val moodDao = MoodDatabase.getInstance(this).getMoodDao()
        MOOD_REPOSITORY = MoodRealization(moodDao)
        val noteDao = NotesDatabase.getInstance(this).getNotesDao()
        NOTE_REPOSITORY = NoteRealization(noteDao)


        binding.bottomNavigationView.setupWithNavController(navController)
    }
}