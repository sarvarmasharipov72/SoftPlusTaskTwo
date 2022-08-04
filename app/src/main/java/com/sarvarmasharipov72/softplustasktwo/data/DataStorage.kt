package com.sarvarmasharipov72.softplustasktwo.data

import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataStorage @Inject constructor (private val context: Context) {

    private val Context.dataStore by preferencesDataStore("counterStart")
    private val COUNTER = intPreferencesKey("counter_key")

    private suspend fun incrementCounter() {
        context.dataStore.edit { settings ->
            val currentCounterValue = settings[COUNTER] ?: 0
            settings[COUNTER] = currentCounterValue + 1
        }
    }

    suspend fun getCounter(): Int {
        incrementCounter()
        return context.dataStore.data.first()[COUNTER] ?: 0

    }
}