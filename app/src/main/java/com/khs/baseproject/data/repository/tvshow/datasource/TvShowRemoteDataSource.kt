package com.khs.baseproject.data.repository.tvshow.datasource

import com.khs.baseproject.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}