package com.saucefan.stuff.m01_threading

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val newasync = MyAsyncTask()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            newasync.execute()
        }

        btn2.setOnClickListener {
          newasync.cancel(true)
        }
    }

    inner class MyAsyncTask: AsyncTask<Unit, Int, String>(){

        override fun onPreExecute() {
            visSwap(tv)
            visSwap(progressBar)
            super.onPreExecute()
        }

        override fun doInBackground(vararg p0: Unit?): String {
            val primeNumbers = primes().take(1600).joinToString(", ")
            return primeNumbers
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            visSwap(tv)
            visSwap(progressBar)
            tv.text = result
        }

        override fun onCancelled() {
            super.onCancelled()
            Log.i("oncanceled", isCancelled.toString())
        }
    }

    override fun onStop() {
        super.onStop()
        Log.i("oncanceled", "Activity Stopped")
        newasync.cancel(true)
    }

    fun primes(): Sequence<Long> {
        var i = 0L
        return sequence {
            generateSequence { i++ }
                .filter { n -> n > 1 && ((2 until n).none { i -> n % i == 0L }) }
                .forEach { yield(it) }
        }
    }

    fun visSwap(view:View) {
        if(view.isVisible==false){
            view.isVisible = true
            }
        else {
            view.isVisible = false
            }
        }
}

