package com.saucefan.stuff.m02_ocean.api

import android.telecom.Call
import retrofit2.http.GET

interface CountriesAPI {

    @GET("<the last portion of your API URL>")
    fun getCountries(region:String): Call<OceaniaCountryList>

}