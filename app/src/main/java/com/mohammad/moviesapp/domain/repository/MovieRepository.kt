package com.mohammad.moviesapp.domain.repository

import com.mohammad.moviesapp.data.model.Movie

interface MovieRepository {

  suspend fun getMovies():List<Movie>?
  suspend fun updateMovies():List<Movie>?

}