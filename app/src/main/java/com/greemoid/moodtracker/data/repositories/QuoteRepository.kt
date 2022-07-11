package com.greemoid.moodtracker.data.repositories

import com.greemoid.moodtracker.data.api.RetrofitInstance

class QuoteRepository {

    suspend fun getQuote() =
        RetrofitInstance.api.getQuote()
}