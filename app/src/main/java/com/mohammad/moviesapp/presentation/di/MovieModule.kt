package com.mohammad.moviesapp.presentation.di

import com.mohammad.moviesapp.domain.useCases.GetMoviesUseCase
import com.mohammad.moviesapp.domain.useCases.UpdateMoviesUseCase
import com.mohammad.moviesapp.presentation.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
   @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ):ViewModelFactory{
        return ViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase)
    }
}