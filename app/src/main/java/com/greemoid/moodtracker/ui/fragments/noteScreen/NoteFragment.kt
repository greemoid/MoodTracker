package com.greemoid.moodtracker.ui.fragments.noteScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.greemoid.moodtracker.R
import com.greemoid.moodtracker.databinding.FragmentNoteBinding
import com.greemoid.moodtracker.models.Note
import com.greemoid.moodtracker.utils.NOTE
import java.text.SimpleDateFormat
import java.util.*


class NoteFragment : Fragment() {

    private lateinit var binding: FragmentNoteBinding
    //private lateinit var currentNote: Note
    private lateinit var viewModel: NoteViewModel

    val args: NoteFragmentArgs by navArgs()


   /* override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        currentNote = arguments?.getSerializable(NOTE) as Note
    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        viewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        val note = args.note

        val date = getCurrentDateTime()
        val dateInString = date.toString("dd.MM.yyyy")
        val timeInString = date.toString("HH:mm")

        binding.apply {
            etTitle.append(note.title)
            etNote.append(note.description)
            textViewDate.text = note.date
            textViewTime.text = note.time

            buttonSaveMood.setOnClickListener {
                val title = etTitle.text.toString()
                val description = etNote.text.toString()
                val updatedNote = Note(
                    id = args.note.id,
                    title = title,
                    description = description,
                    date = dateInString,
                    time = timeInString
                )
                viewModel.updateNote(updatedNote)
            }

            btnBack.setOnClickListener {
                findNavController().navigate(R.id.action_noteFragment_to_listNotesFragment)
            }

            btnDelete.setOnClickListener {
                viewModel.deleteNote(note)
                findNavController().navigate(R.id.action_noteFragment_to_listNotesFragment)
            }
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