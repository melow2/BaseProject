package com.khs.baseproject.data.repository.tvshow.datasource

import com.khs.baseproject.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDB(): List<TvShow>
    suspend fun saveTvShowsToDB(movies: List<TvShow>)
    suspend fun clearAll()
}