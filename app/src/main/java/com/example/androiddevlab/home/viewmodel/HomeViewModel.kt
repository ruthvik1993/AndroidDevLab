package com.example.androiddevlab.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddevlab.R
import com.example.androiddevlab.core.extensions.stateWhileSubscribed
import com.example.androiddevlab.home.viewstate.HomeScreenViewState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject() constructor() : ViewModel() {
    private val _homeScreenViewStateFlow: MutableStateFlow<HomeScreenViewState> =
        MutableStateFlow(buildHomeScreenViewState())
    val homeScreenViewStateFlow: StateFlow<HomeScreenViewState>
        get() = _homeScreenViewStateFlow.stateWhileSubscribed(viewModelScope)

    private val _navigateToDestinationFlow: MutableSharedFlow<Int> = MutableSharedFlow()
    val navigateToDestinationFlow: SharedFlow<Int>
        get() = _navigateToDestinationFlow

    private fun buildHomeScreenViewState() =
        HomeScreenViewState(
            buttonTxt = "Fetch breweries",
            buttonClick = {
                viewModelScope.launch {
                    _navigateToDestinationFlow.emit(R.id.action_home_to_BreweryListFragment)
                }
            }
        )
}