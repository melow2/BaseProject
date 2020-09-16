package com.khs.baseproject.data.repository.tvshow.datasourceImpl

import com.khs.baseproject.data.api.TMDBService
import com.khs.baseproject.data.model.tvshow.TvShowList
import com.khs.baseproject.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apikey:String
): TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apikey)
}