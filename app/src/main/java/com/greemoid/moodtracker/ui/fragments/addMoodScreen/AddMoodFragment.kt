package com.greemoid.moodtracker.ui.fragments.addMoodScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.greemoid.moodtracker.R
import com.greemoid.moodtracker.databinding.FragmentAddMoodBinding
import com.greemoid.moodtracker.models.Mood
import com.greemoid.moodtracker.utils.*
import java.text.SimpleDateFormat
import java.util.*


class AddMoodFragment : Fragment() {

    private lateinit var binding: FragmentAddMoodBinding
    private lateinit var viewModel: AddMoodViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddMoodBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        viewModel = ViewModelProvider(this).get(AddMoodViewModel::class.java)


        val date = getCurrentDateTime()
        val dateInString = date.toString("dd.MM.yyyy")

        binding.buttonSaveMood.setOnClickListener {
            val mood = when(binding.radioGroup.checkedRadioButtonId) {
                R.id.rbHappy -> HAPPY
                R.id.rbLovely -> LOVELY
                R.id.rbNormal -> NORMAL
                R.id.rbSad -> SAD
                R.id.rbVerySad -> VERY_SAD
                else -> HAPPY
            }
            val moodDescription = binding.editTextSayAboutFeelings.text.toString()
            val moodItem = Mood(mood = mood, textOfMood = moodDescription, date = dateInString)
            viewModel.addMood(moodItem){}
            Toast.makeText(requireContext(), "Mood added.", Toast.LENGTH_SHORT).show()
            binding.editTextSayAboutFeelings.text = null
            binding.radioGroup.check(R.id.rbHappy)
        }
    }

    private fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }

    private fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }

}