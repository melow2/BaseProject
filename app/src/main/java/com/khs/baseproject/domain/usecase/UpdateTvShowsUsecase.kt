package com.khs.baseproject.domain.usecase

import com.khs.baseproject.data.model.tvshow.TvShow
import com.khs.baseproject.domain.repository.TvShowRepository

class UpdateTvShowsUsecase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>?  = tvShowRepository.updateTvShows()
}