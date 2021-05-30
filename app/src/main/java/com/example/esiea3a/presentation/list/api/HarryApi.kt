package com.example.esiea3a.presentation.list.api

import retrofit2.Call
import retrofit2.http.GET

interface HarryApi {
    @GET("fakeharrypotterapi.json")
    fun getHarrypotterList(): Call<HarrypotterResponse>
}