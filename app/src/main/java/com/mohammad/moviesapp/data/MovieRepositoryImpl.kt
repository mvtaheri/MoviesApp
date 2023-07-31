package com.mohammad.moviesapp.data

import android.widget.Toast
import com.mohammad.moviesapp.data.datasource.MovieCacheDataSource
import com.mohammad.moviesapp.data.datasource.MovieLocalDataSource
import com.mohammad.moviesapp.data.datasource.MovieRemoteDataSource
import com.mohammad.moviesapp.data.model.Movie
import com.mohammad.moviesapp.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieCacheDataSource:MovieCacheDataSource,
    private val movieLocalDataSource:MovieLocalDataSource,
    private val movieRemoteDataSource:MovieRemoteDataSource
):MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
         return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMoview=getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMoview)
        movieCacheDataSource.saveMoviesToCache(newListOfMoview)
        return newListOfMoview
    }
    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null){
                movieList = body.movies
            }else{
                var m1=Movie(298618,"When his attempt to save his family inadvertently alters the future, Barry Allen becomes trapped in a reality in which General Zod has returned and there are no Super Heroes to turn to. In order to save the world that he is in and return to the future that he knows, Barry's only hope is to race for his life. But will making the ultimate sacrifice be enough to reset the universe?",
                    "/rktDFPbfHfUbArZ6OOOKsXcv0Bm.jpg",	"2023-06-13","The Flash")

                movieList=listOf(m1,m1)
            }

        }catch (exception: java.lang.Exception){

        }
       return movieList
    }
    suspend fun getMoviesFromROOM(): List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        }catch (exception: Exception){

        }
        if (movieList.size> 0){
            return movieList
        }else{
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)

        }
        return movieList

    }



    private suspend fun getMoviesFromCache(): List<Movie>? {
        lateinit var movieList : List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (exception : Exception){

        }
        if (movieList.size > 0 ){
            return movieList
        }else{
            movieList = getMoviesFromROOM()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList






    }
}