package com.greemoid.moodtracker.data.api

import com.greemoid.moodtracker.models.Quote
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApi {

    @GET("quote")
    suspend fun getQuote() : Response<Quote>
}