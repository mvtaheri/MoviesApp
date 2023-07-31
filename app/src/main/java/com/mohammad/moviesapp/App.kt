package com.mohammad.moviesapp

import android.app.Application
import com.mohammad.moviesapp.presentation.di.AppComponent
import com.mohammad.moviesapp.presentation.di.AppModule
import com.mohammad.moviesapp.presentation.di.DaggerAppComponent
import com.mohammad.moviesapp.presentation.di.Injector
import com.mohammad.moviesapp.presentation.di.MovieSubComponent
import com.mohammad.moviesapp.presentation.di.NetModule
import com.mohammad.moviesapp.presentation.di.RemoteDataModule

class App:Application(),Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
           appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
     return appComponent.movieSubComponent().create()
    }
}