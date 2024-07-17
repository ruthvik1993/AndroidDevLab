package com.example.androiddevlab.dagger

import android.content.Context
import com.example.androiddevlab.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/*
* Dagger Application Component
 */

@Singleton
@Component()
interface ApplicationComponent {

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
    fun inject(mainActivity: MainActivity)
}