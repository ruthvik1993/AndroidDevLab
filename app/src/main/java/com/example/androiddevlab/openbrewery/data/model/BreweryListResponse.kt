package com.example.androiddevlab.openbrewery.data.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BreweryListResponse(
    val breweriesList: ArrayList<BreweryDetail>,
): Parcelable