package com.example.alifbee.api

import com.example.alifbee.ui.Constants.MORE_BY_US_API_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retr {
    val api: MyApi by lazy {
        Retrofit.Builder()
            .baseUrl(MORE_BY_US_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)
    }
}