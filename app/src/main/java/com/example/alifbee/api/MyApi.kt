package com.example.alifbee.api

import com.example.alifbee.model.AppsRes
import retrofit2.Response
import retrofit2.http.GET

interface MyApi {

    @GET("/api/v2/general/initial?format=json")
    suspend fun getApps(): Response<AppsRes>
}