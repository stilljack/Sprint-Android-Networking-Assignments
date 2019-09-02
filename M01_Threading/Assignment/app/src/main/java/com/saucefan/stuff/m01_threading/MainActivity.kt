package com.saucefan.stuff.m01_threading

import android.app.PendingIntent
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import java.util.logging.Logger.global

class MainActivity : AppCompatActivity() {


    fun visSwap(view:View){
        if (view.visibility == View.INVISIBLE){
            view.visibility = View.VISIBLE
        }
        else view.visibility = View.INVISIBLE
    }
    fun primes(): Sequence<Long> {
        var i = 0L
        return sequence {
            generateSequence { i++ }
                .filter { n -> n > 1 && ((2 until n).none { i -> n % i == 0L }) }
                .forEach { yield(it) }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView=findViewById<TextView>(R.id.tv)
        val progressBar =findViewById<ProgressBar>(R.id.progressBar)

        class MyAsyncTask : AsyncTask<Unit, Int, String>() {
            override fun doInBackground(vararg p0: Unit?): String {
                val primeNumbers = primes().take(1600).joinToString(", ")
                return primeNumbers
            }

            override fun onPostExecute(result: String?) {
                super.onPostExecute(result)
                visSwap(progressBar)
                visSwap(tv)
                tv.text = result
            }

            override fun onPreExecute() {
                super.onPreExecute()
                visSwap(tv)
                visSwap(progressBar)
            }

            override fun onCancelled() {
                super.onCancelled()
            }

        }

           //progressBar.visibility = View.VISIBLE
                //so that works but...
           // visSwap()
                //just calling the method that worked before doesn't... weird...

       //
       // tv.text = "Primes: $primeNumbers"
       // tv.visibility=View.VISIBLE
       // visSwap()


        //just cause i didn't believe this code would work
       // tv.setOnClickListener{
      //      visSwap()
      //  }
        val new = MyAsyncTask()

        btn.setOnClickListener {
            new.execute()
        }

    }

    override fun onStop() {
        super.onStop()
    }


    //

}
