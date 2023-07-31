package com.mohammad.moviesapp.presentation.di

import com.mohammad.moviesapp.data.datasource.MovieCacheDataSource
import com.mohammad.moviesapp.data.datasourceImpl.MovieCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class CacheDataModule {


    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }
}