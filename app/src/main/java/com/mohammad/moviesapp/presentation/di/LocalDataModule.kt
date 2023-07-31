package com.mohammad.moviesapp.presentation.di

import com.mohammad.moviesapp.data.datasource.MovieLocalDataSource
import com.mohammad.moviesapp.data.datasourceImpl.MovieLocalDataSourceImpl
import com.mohammad.moviesapp.data.db.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
@Singleton
@Provides
fun provideMovieLocalDataSource(movieDao: MovieDao):MovieLocalDataSource{
    return MovieLocalDataSourceImpl(movieDao)
}

}