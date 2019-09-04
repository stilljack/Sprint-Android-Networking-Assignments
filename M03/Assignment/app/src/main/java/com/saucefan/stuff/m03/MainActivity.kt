package com.saucefan.stuff.m03

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private fun isNetworkConnected(){
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        Toast.makeText(this,"is it connected? ${networkInfo.isConnected}",Toast.LENGTH_SHORT).show()
       if (!networkInfo.isConnected){
           Toast.makeText(this,"is it connected? false",Toast.LENGTH_SHORT).show()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("I didn't know this was a thing, neat")

        GetButton.setOnClickListener {
            isNetworkConnected()
            startActivity(Intent(this@MainActivity, HttpDeleteActivity::class.java))



        }

        PutButton.setOnClickListener {
        }

        DeleteButton.setOnClickListener {  }

        PostButton.setOnClickListener {  }


    }
}
