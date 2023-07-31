package com.mohammad.moviesapp.presentation.di

import com.mohammad.moviesapp.presentation.MainActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity:MainActivity)
    @Subcomponent.Factory
    interface Factory{
        fun create(): MovieSubComponent
    }
}

