package com.example.androiddevlab.openbrewery.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.androiddevlab.openbrewery.data.data.model.BreweryDetail
import com.example.androiddevlab.openbrewery.viewstate.BreweryListViewState

@Composable
fun BreweryListScreen (viewState: BreweryListViewState){
    if (viewState.breweryList.isNotEmpty()){
        ItemList(breweryList = viewState.breweryList)
    }
}

@Composable
fun ItemList(breweryList: List<BreweryDetail>){
    LazyColumn {
        items(breweryList) { list->
            BreweryItem(item = list)
        }
    }
}

@Composable
fun BreweryItem(item: BreweryDetail){
    Text(text = item.name, style = MaterialTheme.typography.bodyLarge)
}