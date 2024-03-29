package com.example.databindingexample

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesApi {
    @GET("/quotes")
    suspend fun getQuotes() : Response<Quotes>

    //Base Url : https://quotable.io/
    //@GET("/quotes")
    //suspend fun getQuotes(@Query("a") String a,@Query("b") String b) : Response<Quotes>
    //If we execute customApi.getQuotes("3","5")
    //Url : https://quotable.io/quotes?a=3&b=5
}