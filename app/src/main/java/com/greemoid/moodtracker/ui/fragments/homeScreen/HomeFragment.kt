package com.greemoid.moodtracker.ui.fragments.homeScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.greemoid.moodtracker.R
import com.greemoid.moodtracker.databinding.FragmentHomeBinding
import com.greemoid.moodtracker.models.Quote


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewModel.quote.observe(viewLifecycleOwner, { quote ->
            binding.tvQuotes.text = quote.body()?.text
            binding.tvAuthor.text = quote.body()?.author
        })
        binding.buttonWork.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addMoodFragment)
        }

    }

}