package com.mohammad.moviesapp.domain.useCases

import com.mohammad.moviesapp.data.model.Movie
import com.mohammad.moviesapp.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>?= movieRepository.updateMovies()
}