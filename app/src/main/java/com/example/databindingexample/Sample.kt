package com.example.databindingexample

import com.google.gson.annotations.SerializedName

data class Sample(
    val count: Int,
    val entries: List<Entry>,
    //@SerializedName("sth with - not able to represent in variables") var description: String
)