package com.example.androiddevlab.openbrewery.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddevlab.openbrewery.data.data.repository.BreweryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class BreweryListViewModel @Inject constructor(
    private val breweryRepository: BreweryRepository
): ViewModel() {

    fun onViewCreated(){
        fetchBreweriesList()
    }

    private fun fetchBreweriesList() {
        viewModelScope.launch(Dispatchers.IO){
            val breweriesList = breweryRepository.getBreweriesList()
        }
    }

}