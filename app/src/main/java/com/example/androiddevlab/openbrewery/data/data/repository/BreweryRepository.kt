package com.example.androiddevlab.openbrewery.data.data.repository

import com.example.androiddevlab.network.BreweryAPI
import javax.inject.Inject

class BreweryRepository @Inject constructor(private val breweryApi: BreweryAPI){

    suspend fun getBreweriesList() = breweryApi.getBreweries()
}