package com.mohammad.moviesapp.presentation.di

import android.content.Context
import androidx.room.Room
import com.mohammad.moviesapp.data.db.MovieDao
import com.mohammad.moviesapp.data.db.TMDBdatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

@Singleton
@Provides
fun providesMovieDatabase(contex:Context):TMDBdatabase{
    return Room.databaseBuilder(contex,TMDBdatabase::class.java,"tmdbclient")
        .build()
}

    @Singleton
    @Provides
    fun providesMovieDAO(tmdBdatabase: TMDBdatabase):MovieDao{
        return tmdBdatabase.movieDao()
    }
}