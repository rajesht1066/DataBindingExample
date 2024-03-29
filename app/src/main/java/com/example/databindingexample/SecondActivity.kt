package com.example.databindingexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        GlobalScope.launch(Dispatchers.Main){
            val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
            recyclerview.layoutManager = LinearLayoutManager(applicationContext)

            val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)
            val result = quotesApi.getQuotes()
            val data:List<Result>? = result?.body()?.results
            val adapter = CustomAdapter(data)
            recyclerview.adapter = adapter
        }
    }
}