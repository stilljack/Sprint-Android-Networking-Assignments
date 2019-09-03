package com.saucefan.stuff.m02_ocean.api

import retrofit2.Call
import com.google.gson.GsonBuilder
import com.saucefan.stuff.m02_ocean.model.OceaniaCountryList
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class OceaniaCountriesRetriever {
    companion object {
        private const val TAG = "RETRIEVER"
        internal const val BASE_URL = "https://restcountries.eu/"
    }

    fun getOceaniaCountries(): Call<OceaniaCountryList> {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val countriesAPI = retrofit.create(CountriesAPI::class.java)

        return countriesAPI.getCountries()
    }

}