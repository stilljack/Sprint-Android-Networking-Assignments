package com.saucefan.stuff.m03.allcapsactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.saucefan.stuff.m03.R

class GetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get)

        val type = intent.getStringExtra("get")
        when (type){
            "path" -> Toast.makeText(this,"path", Toast.LENGTH_SHORT).show()
             "query" -> Toast.makeText(this,"query",Toast.LENGTH_SHORT).show()
              "get" -> Toast.makeText(this,"get",Toast.LENGTH_SHORT).show()

        }
    }
}
