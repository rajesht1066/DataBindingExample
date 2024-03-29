package com.example.databindingexample

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    //val baseUrl = "https://quotable.io/"
    //val baseUrl = "http://simplifiedcoding.net/demos/"
    val baseUrl = "https://api.publicapis.org/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            // we need to add converter factory to
            // convert JSON object to Java object
            .build()
    }
}