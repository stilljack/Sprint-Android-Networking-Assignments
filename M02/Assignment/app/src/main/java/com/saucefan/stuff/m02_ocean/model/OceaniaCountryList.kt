package com.saucefan.stuff.m02_ocean.model

import com.google.gson.annotations.SerializedName


data class OceaniaCountryList (
    val countryList: List<OceaniaCountry>// define "OceaniaCountry" class soon...
)


data class OceaniaCountry (

    val name : String,
    val topLevelDomain : List<String>,
    val alpha2Code : String,
    val alpha3Code : String,
    val callingCodes : List<Int>,
    val capital : String,
    val altSpellings : List<String>,
    val region : String,
    val subregion : String,
    val population : Int,
    val latlng : List<Double>,
    val demonym : String,
    val area : Int,
    val gini : String,
    val timezones : List<String>,
    val borders : List<String>,
    val nativeName : String,
    val numericCode : Int,
    val currencies : List<Currencies>,
    val languages : List<Languages>,
    val translations : Translations,
    val flag : String,
    val regionalBlocs : List<String>,
    val cioc : String
)

/*data class Translations (

    val de : String,
    val es : String,
    val fr : String,
    val ja : String,
    val it : String,
    val br : String,
    val pt : String,
    val nl : String,
    val hr : String,
    val fa : String
)*/
data class Currencies (

    val code : String,
    val name : String,
    val symbol : String
)

data class Languages (

    val iso639_1 : String,
    val iso639_2 : String,
    val name : String,
    val nativeName : String
)