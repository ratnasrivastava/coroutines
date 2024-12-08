package com.example.coroutinescopes.di

import com.example.coroutinescopes.model.repository.FetchRepository
import com.example.coroutinescopes.viewModel.FetchingDataViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Ratna Srivastava on 07-12-2024.
 */

@Module
class FetchingModule {

    @Provides
    @Singleton
    fun provideFetchRepository(): FetchRepository {
        return FetchRepository()
    }

    @Provides
    @Singleton
    fun provideViewModel(repository: FetchRepository): FetchingDataViewModel {
        return FetchingDataViewModel(repository)
    }
    }