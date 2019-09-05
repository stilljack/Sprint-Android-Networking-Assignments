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

class PutActivity : AppCompatActivity(), Callback<Employee> {
 var empServe = JsonApiInterface.Factory.create()

    override fun onFailure(call: Call<Employee>, t: Throwable) {
        t.printStackTrace()
        val response = "faliure; ${t.message}"
        Toast.makeText(this@PutActivity, response, Toast.LENGTH_SHORT).show()
    }

    override fun onResponse(
        call: Call<Employee>,
        response: Response<Employee>
    ) {
        Toast.makeText(this@PutActivity, response.body().toString(), Toast.LENGTH_SHORT).show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_put)
        empServe.updateEmployee(Employee("Steve",1,25,"Principal Egnineer")).enqueue(this)

    }
}
