package com.mohammad.moviesapp.presentation.di

import com.mohammad.moviesapp.data.api.TMDBService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory


@Module
class NetModule(private val base_url:String) {

    @Singleton
    @Provides
    fun providesRetrofid():Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(base_url)
            .build()
    }

    @Singleton
    @Provides
    fun providesTMDBService(retrofit: Retrofit):TMDBService{
        return retrofit.create(TMDBService::class.java)
    }

}