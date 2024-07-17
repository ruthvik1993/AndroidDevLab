package com.example.androiddevlab

import android.app.Application
import com.example.androiddevlab.dagger.ApplicationComponent
import com.example.androiddevlab.dagger.DaggerApplicationComponent

class AndroidDevLabApplication : Application() {
    private lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerApplicationComponent.factory().create(applicationContext)

    }
}