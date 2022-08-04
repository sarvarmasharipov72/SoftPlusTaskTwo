package com.sarvarmasharipov72.softplustasktwo

import android.app.Application
import com.sarvarmasharipov72.softplustasktwo.di.AppComponent
import com.sarvarmasharipov72.softplustasktwo.di.DaggerAppComponent

class MainApp : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
    }
}