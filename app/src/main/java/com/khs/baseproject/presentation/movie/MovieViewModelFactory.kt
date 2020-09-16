package com.khs.baseproject.presentation.movie

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.khs.baseproject.domain.usecase.GetMovieUsecase
import com.khs.baseproject.domain.usecase.UpdateMoviesUsecase
import javax.inject.Inject

class MovieViewModelFactory (
    private val mApplication: Application,
    private val getMovieUsecase: GetMovieUsecase,
    private val updateMoviesUsecase: UpdateMoviesUsecase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieViewModel(mApplication, getMovieUsecase,updateMoviesUsecase) as T
    }
}