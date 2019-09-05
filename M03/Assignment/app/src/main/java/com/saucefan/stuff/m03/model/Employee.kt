package com.saucefan.stuff.m03.model

import com.google.gson.annotations.SerializedName

data class Employee (val name:String, val id:Int, val age:Int,  val title:String)

/*
data class AltEmployee(
    @SerializedName("age")
    val age: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("title")
    val title: String
)*/
