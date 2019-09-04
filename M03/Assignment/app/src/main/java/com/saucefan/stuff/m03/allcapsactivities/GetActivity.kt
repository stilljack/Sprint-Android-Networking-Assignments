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

class GetActivity : AppCompatActivity() {
    var employeeService = JsonApiInterface.Factory.create()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get)

        val type = intent.getStringExtra("get")
        when (type) {
            "path" -> {
                title="path"
                getEmployeesById("2")
                Toast.makeText(this, "path", Toast.LENGTH_SHORT).show()
            }
            "query" -> {
                title= "query"
                getEmployeesByAge("2")
                Toast.makeText(this, "query", Toast.LENGTH_SHORT).show()
            }

            "get" -> {
                title= "get"
                getEmployees()
                Toast.makeText(this, "get", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun getEmployeesById(employeeId: String) {

    }

    private fun getEmployeesByAge(age: String) {
        // TODO: Write the call to get an employee by age
    }

    private fun getEmployees() {
        employeeService.getEmployees().enqueue(object: Callback<List<Employee>> {
            override fun onFailure(call: Call<List<Employee>>, t: Throwable) {
                t.printStackTrace()
                val response = "faliure; ${t.message}"
                Toast.makeText(this@GetActivity, response, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<List<Employee>>,
                response: Response<List<Employee>>
            ) {
                Toast.makeText(this@GetActivity, response.body().toString(),Toast.LENGTH_SHORT).show()
            }
        })
    }
}
