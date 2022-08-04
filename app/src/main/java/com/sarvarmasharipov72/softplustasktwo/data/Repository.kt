package com.sarvarmasharipov72.softplustasktwo.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val dataStorage: DataStorage) {


    suspend fun getCounter(): Int {
        return dataStorage.getCounter()
    }
}