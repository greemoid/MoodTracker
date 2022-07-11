package com.greemoid.moodtracker.ui.fragments.moodByDateScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.greemoid.moodtracker.adapters.MoodAdapter
import com.greemoid.moodtracker.databinding.FragmentMoodByDateBinding


class MoodByDateFragment : Fragment() {

    private lateinit var binding: FragmentMoodByDateBinding
    private lateinit var viewModel: MoodByDateViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MoodAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMoodByDateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        viewModel = ViewModelProvider(this).get(MoodByDateViewModel::class.java)
        adapter = MoodAdapter()
        recyclerView = binding.rvMoods
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)


        viewModel.getAllMoods().observe(viewLifecycleOwner, { moodList ->
            adapter.setList(moodList.asReversed())
        })

    }

}