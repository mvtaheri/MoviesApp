package com.mohammad.moviesapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mohammad.moviesapp.data.model.Movie

@Database(entities = [Movie::class] , version = 1)
abstract class TMDBdatabase:RoomDatabase() {
    abstract fun movieDao():MovieDao
}

