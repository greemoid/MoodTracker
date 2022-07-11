package com.greemoid.moodtracker.ui.fragments.notesListScreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.greemoid.moodtracker.R
import com.greemoid.moodtracker.adapters.DiaryAdapter
import com.greemoid.moodtracker.databinding.FragmentListNotesBinding
import com.greemoid.moodtracker.utils.NOTE


class ListNotesFragment : Fragment() {

    private lateinit var binding: FragmentListNotesBinding
    private lateinit var viewModel: NotesListViewModel
    private lateinit var adapter: DiaryAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListNotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        viewModel = ViewModelProvider(this).get(NotesListViewModel::class.java)

        adapter = DiaryAdapter()
        recyclerView = binding.recyclerViewNotes
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)


        viewModel.getAllNotes().observe(viewLifecycleOwner, { listNotes ->
            adapter.setList(listNotes.asReversed())
            Log.d("INIT", "${listNotes}")
        })



        binding.addFab.setOnClickListener {
            findNavController().navigate(R.id.action_listNotesFragment_to_noteAddFragment)
        }

        adapter.setOnItemClickListener {
            val bundle = Bundle()
            bundle.putSerializable(NOTE, it)
            findNavController().navigate(
                R.id.action_listNotesFragment_to_noteFragment,
                bundle
            )
        }
    }




}