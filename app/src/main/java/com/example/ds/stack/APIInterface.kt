package com.example.ds.stack

import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {
    @GET("demo_api.json")
    fun getData() : Call<Status>
}