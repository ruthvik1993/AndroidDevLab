package com.example.androiddevlab.home.viewstate

data class HomeScreenViewState(
    val buttonTxt: String,
    val buttonClick: (()-> Unit)? = null
)