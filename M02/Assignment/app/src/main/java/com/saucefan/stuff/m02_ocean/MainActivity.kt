package com.saucefan.stuff.m02_ocean

import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saucefan.stuff.m02_ocean.api.OceaniaCountriesRetriever
import com.saucefan.stuff.m02_ocean.fragments.wtfFragment
import com.saucefan.stuff.m02_ocean.model.wtf
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.saucefan.stuff.m02_ocean.recycleview.Adapter

class MainActivity : AppCompatActivity(), Callback<List<wtf>>,
    wtfFragment.OnListFragmentInteractionListener {
    override fun onListFragmentInteraction(item: wtf) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private lateinit var layoutManager: GridLayoutManager
    private lateinit var adapter: Adapter

    companion object {
       var mutlist = mutableListOf<wtf>()
    }


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
            Log.i("the plane from lost?","$mutlist")
            adapter.notifyDataSetChanged()
            layoutManager = GridLayoutManager(this, mutlist.size)
            recycleView.layoutManager = layoutManager
            tv_ctv.text = oceanMan

        } else {
            val response = "response not successful; ${response.errorBody().toString()}"
            Toast.makeText(this@MainActivity, response, Toast.LENGTH_SHORT).show()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       adapter=Adapter(mutlist)
        layoutManager = GridLayoutManager(this, 10)
        recycleView.layoutManager = layoutManager
        btn_fetch.setOnClickListener {
            OceaniaCountriesRetriever().getOceaniaCountries().enqueue(this)
        }
        btn_frag.setOnClickListener{
            val manager = supportFragmentManager
            val bundle = Bundle()
            val fragment:Fragment = wtfFragment.newInstance(12)
            manager.beginTransaction()

                .replace(R.id.cl, fragment, "first")
                .addToBackStack("thisbacko")
                .commit()
        }


    }

}
