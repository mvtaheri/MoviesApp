package com.mohammad.moviesapp.presentation.di

import com.mohammad.moviesapp.data.api.TMDBService
import com.mohammad.moviesapp.data.datasource.MovieRemoteDataSource
import com.mohammad.moviesapp.data.datasourceImpl.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey:String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService):MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(tmdbService,apiKey)
    }
}