package com.mohammad.moviesapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mohammad.moviesapp.domain.useCases.GetMoviesUseCase
import com.mohammad.moviesapp.domain.useCases.UpdateMoviesUseCase

class ViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return com.mohammad.moviesapp.presentation.MovieViewModel(getMoviesUseCase,updateMoviesUseCase) as T
    }
}