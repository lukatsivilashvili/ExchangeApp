package com.example.exchange.retrofit

import com.example.exchange.models.responseItem
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitRepo {
    @GET("/gw/api/ct/monetarypolicy/currencies/ka/json")
    suspend fun getExchange(): Response<List<responseItem>>
}