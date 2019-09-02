package com.saucefan.stuff.m01_threading

import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv.visibility = View.GONE


           progressBar.visibility = View.VISIBLE
                //so that works but...
           // visSwap()
                //just calling the method that worked before doesn't... weird...

        val primeNumbers = primes().take(16000).joinToString(", ")
        tv.text = "Primes: $primeNumbers"
        tv.visibility=View.VISIBLE
        visSwap()


        //just cause i didn't believe this code would work
       // tv.setOnClickListener{
      //      visSwap()
      //  }
    }



    //
    fun visSwap(){
        if (progressBar.visibility == View.GONE){
            progressBar.visibility = View.VISIBLE
        }
        else progressBar.visibility = View.GONE
    }
    fun primes(): Sequence<Long> {
        var i = 0L
        return sequence {
            generateSequence { i++ }
                .filter { n -> n > 1 && ((2 until n).none { i -> n % i == 0L }) }
                .forEach { yield(it) }
        }
    }

}
