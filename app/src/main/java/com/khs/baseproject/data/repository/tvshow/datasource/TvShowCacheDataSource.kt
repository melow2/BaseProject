package com.khs.baseproject.data.repository.tvshow.datasource

import com.khs.baseproject.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache(): List<TvShow>
    suspend fun saveTvShowsToCache(movies: List<TvShow>)
}