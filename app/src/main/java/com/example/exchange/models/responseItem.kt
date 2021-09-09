package com.example.exchange.models


import com.google.gson.annotations.SerializedName

data class responseItem(
    @SerializedName("currencies")
    val currencies: List<Currency>?
)