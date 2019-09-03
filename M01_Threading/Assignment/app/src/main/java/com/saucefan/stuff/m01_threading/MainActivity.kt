package com.saucefan.stuff.m01_threading

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity() : AppCompatActivity() {
lateinit var new:AsyncTask<Unit, Int, String>
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
                val primeNumbers = primes().take(16000).joinToString(", ")
                return primeNumbers

            }

            override fun onPostExecute(result: String?) {
                super.onPostExecute(result)
                visSwap(progressBar)
                visSwap(tv)
                tv.text = result
                if (isCancelled()){
                    Log.i("stopped","onpostexecute")
                }
            }

            override fun onPreExecute() {
                super.onPreExecute()
                visSwap(tv)
                visSwap(progressBar)
            }

            override fun onCancelled() {
                super.onCancelled()
                Log.i("stoped","oncanceled")
            }

        }


        val new = MyAsyncTask()

        btn.setOnClickListener {
            new.execute()

        }

    }

    override fun onStop() {

        new.cancel(true)
        super.onStop()
    }


    //

}
