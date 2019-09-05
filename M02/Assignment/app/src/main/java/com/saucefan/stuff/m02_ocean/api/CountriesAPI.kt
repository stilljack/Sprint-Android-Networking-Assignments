package com.saucefan.stuff.m02_ocean.api

import com.saucefan.stuff.m02_ocean.model.OceaniaCountry
import retrofit2.Call
import com.saucefan.stuff.m02_ocean.model.OceaniaCountryList
import com.saucefan.stuff.m02_ocean.model.wtf
import retrofit2.http.GET

interface CountriesAPI {

    @GET("region/Oceania/")
    //then create a function to call the api from the web and populate the list
    fun getCountries(): Call<List<wtf>>

}