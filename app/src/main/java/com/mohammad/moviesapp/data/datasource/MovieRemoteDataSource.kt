package com.mohammad.moviesapp.data.datasource

import com.mohammad.moviesapp.data.model.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}