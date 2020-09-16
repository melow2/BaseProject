package com.khs.baseproject.presentation.tvshow

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.khs.baseproject.domain.usecase.GetMovieUsecase
import com.khs.baseproject.domain.usecase.GetTvShowsUsecase
import com.khs.baseproject.domain.usecase.UpdateMoviesUsecase
import com.khs.baseproject.domain.usecase.UpdateTvShowsUsecase

class TvShowViewModelFactory(
    private val mApplication: Application,
    private val getTvShowsUsecase: GetTvShowsUsecase,
    private val updateTvShowsUsecase: UpdateTvShowsUsecase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TvShowViewModel(mApplication, getTvShowsUsecase,updateTvShowsUsecase) as T
    }
}