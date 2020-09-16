package com.khs.baseproject.presentation.di.movie

import android.app.Application
import com.khs.baseproject.domain.usecase.GetMovieUsecase
import com.khs.baseproject.domain.usecase.UpdateMoviesUsecase
import com.khs.baseproject.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        application: Application,
        getMoviesUseCase: GetMovieUsecase,
        updateMoviesUsecase: UpdateMoviesUsecase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            application,
            getMoviesUseCase,
            updateMoviesUsecase
        )
    }

}