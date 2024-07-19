package com.example.androiddevlab.openbrewery.data.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BreweryDetail(
    val id: String,
    val nane: String,
    val brewery_type: String,
    val address_1: String,
    val address_2: String,
    val address_3: String,
    val city: String,
    val state_province: String,
    val postal_code: String,
    val country: String,
    val longitude: String,
    val latitude: String,
    val phone: String,
    val website_url: String,
    val state: String,
    val street: String
): Parcelable
