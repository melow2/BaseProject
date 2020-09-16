package com.khs.baseproject.presentation.movie

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.liveData
import com.khs.baseproject.domain.usecase.GetMovieUsecase
import com.khs.baseproject.domain.usecase.UpdateMoviesUsecase

class MovieViewModel(
    application: Application,
    private val getMoviesUseCase: GetMovieUsecase,
    private val updateMoviesUsecase: UpdateMoviesUsecase
):AndroidViewModel(application),LifecycleObserver {

    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUsecase.execute()
        emit(movieList)
    }

}