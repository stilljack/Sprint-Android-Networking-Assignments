package com.saucefan.stuff.m02_ocean.model


data class OceaniaCountryList (
    val country: List<OceaniaCountry>// define "OceaniaCountry" class soon...
){
    override fun toString(): String {
        return "whelp $country"
    }
}


data class OceaniaCountry (
    val alpha2code: String,
    val capital: String,
    val subregion: String
    // other fields here
    //if the json done has field not defined here
    //they are simply ignored (thank god for that)
) {
    fun retName(){

    }
}