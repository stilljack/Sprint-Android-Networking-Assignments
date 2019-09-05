package com.saucefan.stuff.m02_ocean.model

import com.google.gson.annotations.SerializedName


data class OceaniaCountryList (
    val countryList: List<OceaniaCountry>// define "OceaniaCountry" class soon...
)


data class OceaniaCountry (
    @SerializedName("alpha2Code")
    val alpha2Code: String,
    @SerializedName("alpha3Code")
    val alpha3Code: String,
    @SerializedName("altSpellings")
    val altSpellings: List<String>,
    @SerializedName("area")
    val area: Double,
    @SerializedName("borders")
    val borders: List<Any>,
    @SerializedName("callingCodes")
    val callingCodes: List<String>,
    @SerializedName("capital")
    val capital: String,
    @SerializedName("cioc")
    val cioc: String,
    @SerializedName("currencies")
    val currencies: List<Currency>,
    @SerializedName("demonym")
    val demonym: String,
    @SerializedName("flag")
    val flag: String,
    @SerializedName("gini")
    val gini: Double,
    @SerializedName("languages")
    val languages: List<Language>,
    @SerializedName("latlng")
    val latlng: List<Double>,
    @SerializedName("name")
    val name: String,
    @SerializedName("nativeName")
    val nativeName: String,
    @SerializedName("numericCode")
    val numericCode: String,
    @SerializedName("population")
    val population: Int,
    @SerializedName("region")
    val region: String,
    @SerializedName("regionalBlocs")
    val regionalBlocs: List<Any>,
    @SerializedName("subregion")
    val subregion: String,
    @SerializedName("timezones")
    val timezones: List<String>,
    @SerializedName("topLevelDomain")
    val topLevelDomain: List<String>,
    @SerializedName("translations")
    val translations: Translations

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