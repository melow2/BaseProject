package com.khs.baseproject.presentation.di.movie


import com.khs.baseproject.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)
    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponent
    }

}

