package com.mohammad.moviesapp.data.datasourceImpl

import com.mohammad.moviesapp.data.api.TMDBService
import com.mohammad.moviesapp.data.datasource.MovieRemoteDataSource
import com.mohammad.moviesapp.data.model.MovieList
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
):MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> =
        tmdbService.getPopularMovies(apiKey)
}