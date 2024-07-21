package com.example.androiddevlab.network

import com.example.androiddevlab.openbrewery.data.data.model.BreweryDetail
import com.example.androiddevlab.openbrewery.data.data.model.BreweryListResponse
import retrofit2.http.GET

interface BreweryAPI {

    @GET("breweries")
    suspend fun getBreweries() : List<BreweryDetail>
}