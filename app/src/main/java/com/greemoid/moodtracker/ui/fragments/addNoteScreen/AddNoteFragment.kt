package com.greemoid.moodtracker.ui.fragments.addNoteScreen

import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import com.greemoid.moodtracker.R
import com.greemoid.moodtracker.databinding.FragmentNoteAddBinding
import com.greemoid.moodtracker.models.Note
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


class AddNoteFragment : Fragment() {

    private lateinit var binding: FragmentNoteAddBinding
    private lateinit var viewModel: AddNoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNoteAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        viewModel = ViewModelProvider(this).get(AddNoteViewModel::class.java)

        val date = getCurrentDateTime()
        val dateInString = date.toString("dd.MM.yyyy")
        val timeInString = date.toString("HH:mm")

        binding.textViewDate.text = dateInString
        binding.textViewTime.text = timeInString

        binding.buttonSaveMood.setOnClickListener {
            val title = binding.editTextTitleOfNote.text.toString()
            val description = binding.editTextTextOfNote.text.toString()

            val note = Note(title = title, description = description, date = dateInString, time = timeInString)
            viewModel.insert(note){}
            findNavController().navigate(R.id.action_noteAddFragment_to_listNotesFragment)
        }

        binding.btnBackAddFrag.setOnClickListener {
            findNavController().navigate(R.id.action_noteAddFragment_to_listNotesFragment)
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