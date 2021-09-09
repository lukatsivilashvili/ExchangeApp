package com.example.exchange.ui

import android.util.Log.d
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exchange.models.responseItem
import com.example.exchange.retrofit.RetrofitService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExchangeViewModel : ViewModel() {
    private val exchangeLiveData = MutableLiveData<List<responseItem>>().apply {
        mutableListOf<responseItem>()
    }

    val _exchangeLiveData: LiveData<List<responseItem>> = exchangeLiveData

    fun init() {
        CoroutineScope(Dispatchers.IO).launch {
            getPhotos()
        }
    }


    private suspend fun getPhotos() {
        val result = RetrofitService.service().getExchange()

        if (result.isSuccessful) {
            val items = result.body()
            d("info", items.toString())
            exchangeLiveData.postValue(items)
        }
    }
}