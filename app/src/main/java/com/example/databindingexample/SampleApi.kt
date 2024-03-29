package com.example.databindingexample

import retrofit2.Response
import retrofit2.http.GET

interface SampleApi {
    @GET("/quotes")
    suspend fun getQuotes() : Response<Quotes>

    @GET("/entries")
    suspend fun getSample() : Response<Sample>
}