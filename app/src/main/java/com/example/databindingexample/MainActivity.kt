package com.example.databindingexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.databindingexample.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

//        binding.textView.text = "Binding Working Fine"
//        binding.textView.textSize = 20F
//        binding.textView2.text = "Hello World"
//        binding.button.setOnClickListener {
//            Toast.makeText(this,"Working Fine",Toast.LENGTH_SHORT).show()
//        }

//        val person = Person("Rajesh","Chodisetti",22)
//        binding.person = person


//        val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)
//        GlobalScope.launch(Dispatchers.IO) {
//            val result = quotesApi.getQuotes()
//            Log.d("check",result?.body().toString())
//        }

//        val marvelApi = RetrofitHelper.getInstance().create(MarvelApi::class.java)
//        GlobalScope.launch(Dispatchers.IO) {
//            val result = marvelApi.getMarvel()
//            Log.d("check",result?.body().toString())
//        }

        val sampleApi = RetrofitHelper.getInstance().create(SampleApi::class.java)
       val job = GlobalScope.async(Dispatchers.IO) {
            sampleApi.getSample()
            //Log.d("check",result?.body().toString())

        }

        GlobalScope.launch(Dispatchers.Main) {
            //job.join()

            //binding.textView.text = "hhhhh"

            Log.d("response",job.await().body().toString())
            binding.textView.text = job.await().body()?.count.toString()
        }


        for (i in 1..10000){
            Log.d("check","devc")
        }


    }
}