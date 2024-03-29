package com.example.databindingexample

import retrofit2.Response
import retrofit2.http.GET

interface MarvelApi {
    @GET("/marvel")
    suspend fun getMarvel() : Response<Marvel>
}