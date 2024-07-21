package com.example.androiddevlab.dagger.modules

import androidx.lifecycle.ViewModel
import com.example.androiddevlab.ViewModelKey
import com.example.androiddevlab.home.viewmodel.HomeViewModel
import com.example.androiddevlab.openbrewery.viewmodel.BreweryListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AndroidDevViewModelModule(){
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun getHomeViewModel(
        viewModel: HomeViewModel
    ): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BreweryListViewModel::class)
    abstract fun getBreweryListViewModel(
        viewModel: BreweryListViewModel
    ): ViewModel
}