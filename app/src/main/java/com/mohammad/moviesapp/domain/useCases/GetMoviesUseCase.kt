package com.mohammad.moviesapp.domain.useCases

import com.mohammad.moviesapp.data.model.Movie
import com.mohammad.moviesapp.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>? = movieRepository.getMovies()
}