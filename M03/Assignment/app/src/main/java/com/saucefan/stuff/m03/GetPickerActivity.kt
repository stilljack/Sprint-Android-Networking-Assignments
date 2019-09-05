package com.saucefan.stuff.m03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.saucefan.stuff.m03.allcapsactivities.GetActivity
import kotlinx.android.synthetic.main.activity_get_picker.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.GetButton

class GetPickerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_picker)



GetButton.setOnClickListener {
    val intent = Intent(this@GetPickerActivity, GetActivity::class.java)
    intent.putExtra("get", "get")
    startActivity(intent)
}
        GetWithPathButton.setOnClickListener {
            val intent = Intent(this@GetPickerActivity, GetActivity::class.java)
            intent.putExtra("get", "path")
            startActivity(intent)
        }
        GetWithQueryButton.setOnClickListener {
            val intent = Intent(this@GetPickerActivity, GetActivity::class.java)
            intent.putExtra("get", "query")
            startActivity(intent)
        }



    }
}
