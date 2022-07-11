package com.greemoid.moodtracker.ui.fragments.homeScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greemoid.moodtracker.data.repositories.QuoteRepository
import com.greemoid.moodtracker.models.Quote
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel : ViewModel() {
    private val quoteRepository = QuoteRepository()
    val quote: MutableLiveData<Response<Quote>> = MutableLiveData()

    init {
        getQuote()
    }

     fun getQuote() = viewModelScope.launch {
        quote.value = quoteRepository.getQuote()
    }


}