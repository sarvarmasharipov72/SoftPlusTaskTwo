package com.sarvarmasharipov72.softplustasktwo.di

import android.content.Context
import com.sarvarmasharipov72.softplustasktwo.MainActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Singleton
@Component
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
    fun inject (mainActivity: MainActivity)
}

@Module
interface AppModule {
}