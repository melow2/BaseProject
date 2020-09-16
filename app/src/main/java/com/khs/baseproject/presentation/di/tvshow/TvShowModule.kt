package com.khs.baseproject.presentation.di.tvshow

import android.app.Application
import com.khs.baseproject.domain.usecase.GetTvShowsUsecase
import com.khs.baseproject.domain.usecase.UpdateTvShowsUsecase
import com.khs.baseproject.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        application: Application,
        getTvShowsUseCase: GetTvShowsUsecase,
        updateTvShowsUseCase: UpdateTvShowsUsecase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            application,
            getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }

}