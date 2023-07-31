package com.mohammad.moviesapp.data.datasourceImpl

import com.mohammad.moviesapp.data.datasource.MovieCacheDataSource
import com.mohammad.moviesapp.data.model.Movie

class MovieCacheDataSourceImpl:MovieCacheDataSource {
    private var moviesList=ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return moviesList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        moviesList.clear()
        moviesList=ArrayList(movies)
    }
}