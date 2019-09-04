package com.saucefan.stuff.m02_ocean

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.saucefan.stuff.m02_ocean.api.OceaniaCountriesRetriever
import com.saucefan.stuff.m02_ocean.model.wtf
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.saucefan.stuff.m02_ocean.recycleview.Adapter

class MainActivity : AppCompatActivity(), Callback<List<wtf>> {
    private lateinit var layoutManager: GridLayoutManager
    private lateinit var adapter: Adapter
    private lateinit var mutlist:MutableList<wtf>


    override fun onFailure(call: Call<List<wtf>>, t: Throwable) {
        t.printStackTrace()
        val response = "faliure; ${t.message}"
        Toast.makeText(this@MainActivity, response, Toast.LENGTH_SHORT).show()
    }



    override fun onResponse(call: Call<List<wtf>>, response: Response<List<wtf>>) {
        if (response.isSuccessful) {
            val oceaniaCountryList:List<wtf>? = response.body()
            var oceanMan = ""
            for (i in 0 until  oceaniaCountryList?.size as Int) {
                oceanMan += oceaniaCountryList[i].name
                mutlist.add(oceaniaCountryList[i])
            }
            Log.i("the plane from lost?","$oceaniaCountryList")
            tv_ctv.text = oceanMan
            adapter=Adapter(mutlist)
            layoutManager = GridLayoutManager(this, mutlist.size)
            recycleView.layoutManager = layoutManager
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
