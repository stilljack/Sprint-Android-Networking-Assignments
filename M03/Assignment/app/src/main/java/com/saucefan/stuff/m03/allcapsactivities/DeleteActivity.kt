package com.saucefan.stuff.m03.allcapsactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.saucefan.stuff.m03.R
import com.saucefan.stuff.m03.api.JsonApiInterface
import com.saucefan.stuff.m03.model.Employee
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DeleteActivity : AppCompatActivity(), Callback<Void> {
    var empServe = JsonApiInterface.Factory.create()

    override fun onFailure(call: Call<Void>, t: Throwable) {
        t.printStackTrace()
        val response = "faliure; ${t.message}"
        Toast.makeText(this@DeleteActivity, response, Toast.LENGTH_SHORT).show()
    }

    override fun onResponse(call: Call<Void>, response: Response<Void>) {
        if (response.isSuccessful) {
            Toast.makeText(this@DeleteActivity, "successfullly deleteedd", Toast.LENGTH_SHORT)
                .show()
        }else
            Toast.makeText(this@DeleteActivity, "still not working", Toast.LENGTH_SHORT)
                .show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)


        empServe.deleteEmployee("1").enqueue(this)
    }
}
