package com.mohammad.moviesapp.presentation.di

import com.mohammad.moviesapp.data.MovieRepositoryImpl
import com.mohammad.moviesapp.data.datasource.MovieCacheDataSource
import com.mohammad.moviesapp.data.datasource.MovieLocalDataSource
import com.mohammad.moviesapp.data.datasource.MovieRemoteDataSource
import com.mohammad.moviesapp.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providesMovieRepository(
        movieCacheDataSource: MovieCacheDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieRemoteDataSource: MovieRemoteDataSource)
    :MovieRepository{
      return MovieRepositoryImpl(
          movieCacheDataSource,movieLocalDataSource,movieRemoteDataSource
      )
    }
}