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

class PostAcitivty : AppCompatActivity() {
    var empServe = JsonApiInterface.Factory.create()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_acitivty)
        empServe.addNewEmployee(Employee("David",7,30,"intern")).enqueue(object: Callback<Employee> {
            override fun onFailure(call: Call<Employee>, t: Throwable) {
                t.printStackTrace()
                val response = "faliure; ${t.message}"
                Toast.makeText(this@PostAcitivty, response, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<Employee>,
                response: Response<Employee>
            ) {
                Toast.makeText(this@PostAcitivty, response.body().toString(), Toast.LENGTH_SHORT).show()
            }
        })

    }
}
