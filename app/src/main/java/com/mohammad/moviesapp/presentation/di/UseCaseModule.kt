package com.mohammad.moviesapp.presentation.di

import com.mohammad.moviesapp.domain.repository.MovieRepository
import com.mohammad.moviesapp.domain.useCases.GetMoviesUseCase
import com.mohammad.moviesapp.domain.useCases.UpdateMoviesUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun providesGetMovieUserCase(movieRepository: MovieRepository):GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }

   @Provides
   fun providesUpdateMovieUseCase(movieRepository: MovieRepository):UpdateMoviesUseCase{
       return UpdateMoviesUseCase(movieRepository)
   }

}