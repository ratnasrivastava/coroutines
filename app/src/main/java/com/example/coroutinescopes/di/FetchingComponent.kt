package com.example.coroutinescopes.di

import com.example.coroutinescopes.MainActivity
import  javax.inject.Singleton
import dagger.Component

/**
 * Created by Ratna Srivastava on 07-12-2024.
 */
@Singleton
@Component(modules = [FetchingModule::class])
interface FetchingComponent {
    fun inject(activity: MainActivity)
}