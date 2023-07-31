package com.mohammad.moviesapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mohammad.moviesapp.domain.useCases.GetMoviesUseCase
import com.mohammad.moviesapp.domain.useCases.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovies() = liveData {
        val moviesList = getMoviesUseCase.execute()
        emit(moviesList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }
}