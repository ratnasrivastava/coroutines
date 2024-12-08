package com.example.coroutinescopes.model.repository

import android.util.Log
import kotlinx.coroutines.delay

/**
 * Created by Ratna Srivastava on 05-12-2024.
 */
class FetchRepository {
    suspend fun getData(): String {
        println("Before delay Fetching data from repository 1")
        delay(1000)
        println("After Delay Fetching data from repository 1")
        return "Ratna"
    }
}