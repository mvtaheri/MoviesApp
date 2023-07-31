package com.mohammad.moviesapp.data.datasource

import com.mohammad.moviesapp.data.model.Movie

interface MovieCacheDataSource {

    suspend fun getMoviesFromCache():List<Movie>

    suspend fun saveMoviesToCache(movies:List<Movie>)
}