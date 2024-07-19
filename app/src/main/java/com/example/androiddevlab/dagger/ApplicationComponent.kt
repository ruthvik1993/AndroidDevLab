package com.example.androiddevlab.dagger

import android.content.Context
import com.example.androiddevlab.MainActivity
import com.example.androiddevlab.dagger.modules.NetworkModule
import com.example.androiddevlab.openbrewery.view.BreweryListFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/*
* Dagger Application Component
 */

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
    fun inject(mainActivity: MainActivity)
    fun inject(breweryListFragment: BreweryListFragment)
}