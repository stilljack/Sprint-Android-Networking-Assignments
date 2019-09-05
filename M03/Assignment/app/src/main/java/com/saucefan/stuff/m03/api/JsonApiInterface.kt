package com.saucefan.stuff.m03.api

import com.google.gson.Gson
import com.saucefan.stuff.m03.model.Employee
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

interface JsonApiInterface {
    @GET("employees")
    fun getEmployees(): Call<List<Employee>>

    @GET("employees/{id}")
    fun getEmployees(@Path("id") employeeId: String): Call<List<Employee>>

    @GET("employees")
    fun getEmployeeByAge(@Query("age") employeeId: String): Call<List<Employee>>

    @POST("employees")
    fun addNewEmployee(@Body employee: Employee): Call<Employee>

    @PUT("employees")
    fun updateEmployee(@Body employee: Employee): Call<Employee>

    @DELETE("employee/{id}")
    fun deleteEmployee(@Path("id") id: String): Call<Void>

    class Factory {
        companion object {
            val BASE_URL = "https://demo8143297.mockable.io"
            val gson = Gson()


            fun create(): JsonApiInterface {
                val logger = HttpLoggingInterceptor()
                logger.level = HttpLoggingInterceptor.Level.BASIC
                logger.level = HttpLoggingInterceptor.Level.BODY
                val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(logger)
                    .retryOnConnectionFailure(false)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .build()
                val retrofit = Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson)) //gson
                    .build()

                return retrofit.create(JsonApiInterface::class.java)
            }
        }
    }

}