package com.saucefan.stuff.m02_ocean.api

import retrofit2.Call
import com.saucefan.stuff.m02_ocean.model.OceaniaCountryList
import retrofit2.http.GET

interface CountriesAPI {

    @GET("region/Oceania")
    fun getCountries(): Call<OceaniaCountryList>

}