package com.saucefan.stuff.m02_ocean

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.saucefan.stuff.m02_ocean.api.OceaniaCountriesRetriever
import com.saucefan.stuff.m02_ocean.model.OceaniaCountryList
import kotlinx.android.synthetic.main.activity_main.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Callback<OceaniaCountryList> {
    override fun onFailure(call: Call<OceaniaCountryList>, t: Throwable) {
        t.printStackTrace()
        val response = "faliure; ${t.printStackTrace()}"
        Toast.makeText(this@MainActivity, response, Toast.LENGTH_SHORT).show()
    }

    override fun onResponse(call: Call<OceaniaCountryList>, response: Response<OceaniaCountryList>) {
        if (response.isSuccessful) {
            val oceaniaCountryList = response.body()
            tv_ctv.text = oceaniaCountryList.toString() // use "oceaniaCountryList" to populate this TextView
        } else {
            val response = "response not successful; ${response.errorBody().toString()}"
            Toast.makeText(this@MainActivity, response, Toast.LENGTH_SHORT).show()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_fetch.setOnClickListener {
            OceaniaCountriesRetriever().getOceaniaCountries().enqueue(this)
        }


    }

}
