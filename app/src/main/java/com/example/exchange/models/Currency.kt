package com.example.exchange.models


import com.google.gson.annotations.SerializedName

data class Currency(
    @SerializedName("code")
    val code: String?,
    @SerializedName("date")
    val date: String?,
    @SerializedName("diff")
    val diff: Double?,
    @SerializedName("diffFormated")
    val diffFormated: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("quantity")
    val quantity: Int?,
    @SerializedName("rate")
    val rate: Double?,
    @SerializedName("rateFormated")
    val rateFormated: String?,
    @SerializedName("validFromDate")
    val validFromDate: String?
)