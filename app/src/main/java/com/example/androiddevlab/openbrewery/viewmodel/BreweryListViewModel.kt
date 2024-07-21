package com.example.androiddevlab.openbrewery.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddevlab.core.extensions.stateWhileSubscribed
import com.example.androiddevlab.openbrewery.data.data.repository.BreweryRepository
import com.example.androiddevlab.openbrewery.viewstate.BreweryListViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class BreweryListViewModel @Inject constructor(
    private val breweryRepository: BreweryRepository
) : ViewModel() {

    private val _breweryListViewStateFlow: MutableStateFlow<BreweryListViewState> =
        MutableStateFlow(buildBreweryListViewState())
    val breweryListViewStateFlow: StateFlow<BreweryListViewState>
        get() = _breweryListViewStateFlow.stateWhileSubscribed(viewModelScope)

    fun onViewCreated() {
        fetchBreweriesList()
    }

    private fun buildBreweryListViewState() = BreweryListViewState(breweryList = ArrayList())

    private fun fetchBreweriesList() {
        viewModelScope.launch(Dispatchers.IO) {
            val breweriesList = breweryRepository.getBreweriesList()
            _breweryListViewStateFlow.update {
                it.copy(
                    breweryList = breweriesList
                )
            }
        }
    }

}