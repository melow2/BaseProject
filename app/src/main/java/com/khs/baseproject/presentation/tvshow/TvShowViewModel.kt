package com.khs.baseproject.presentation.tvshow

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.liveData
import com.khs.baseproject.domain.usecase.GetMovieUsecase
import com.khs.baseproject.domain.usecase.GetTvShowsUsecase
import com.khs.baseproject.domain.usecase.UpdateMoviesUsecase
import com.khs.baseproject.domain.usecase.UpdateTvShowsUsecase

class TvShowViewModel(
    application: Application,
    private val getTvShowsUsecase: GetTvShowsUsecase,
    private val updateTvShowsUsecase: UpdateTvShowsUsecase
):AndroidViewModel(application),LifecycleObserver {

    fun getTvShows() = liveData {
        val tvShowList = getTvShowsUsecase.execute()
        emit(tvShowList)
    }

    fun updateTvShows() = liveData {
        val tvShowList = updateTvShowsUsecase.execute()
        emit(tvShowList)
    }

}