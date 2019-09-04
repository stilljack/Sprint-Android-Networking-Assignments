package com.saucefan.stuff.m03

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.saucefan.stuff.m03.allcapsactivities.DeleteActivity
import com.saucefan.stuff.m03.allcapsactivities.PostAcitivty
import com.saucefan.stuff.m03.allcapsactivities.PutActivity
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.internal.waitMillis

class MainActivity : AppCompatActivity() {
    private fun isNetworkConnected():Boolean{
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        Toast.makeText(this,"is it connected? ${networkInfo.isConnected}",Toast.LENGTH_SHORT).show()

        return networkInfo.isConnected
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("I didn't know this was a thing, neat")

        GetButton.setOnClickListener {

            if (!isNetworkConnected()){
                Toast.makeText(this,"is it connected? false",Toast.LENGTH_SHORT).show()
            } else
            startActivity(Intent(this, GetPickerActivity::class.java))
        }

        PutButton.setOnClickListener {
            if (!isNetworkConnected()){
                Toast.makeText(this,"is it connected? false",Toast.LENGTH_SHORT).show()
            } else
            startActivity(Intent(this, PutActivity::class.java))
        }

        DeleteButton.setOnClickListener {
            if (!isNetworkConnected()){
                Toast.makeText(this,"is it connected? false",Toast.LENGTH_SHORT).show()
            } else
            startActivity(Intent(this, DeleteActivity::class.java))
        }

        PostButton.setOnClickListener {
            if (!isNetworkConnected()){
                Toast.makeText(this,"is it connected? false",Toast.LENGTH_SHORT).show()
            } else
            startActivity(Intent(this, PostAcitivty::class.java))
        }




    }
}
