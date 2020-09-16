package com.khs.baseproject.data.repository.tvshow.datasourceImpl

import com.khs.baseproject.data.model.tvshow.TvShow
import com.khs.baseproject.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl: TvShowCacheDataSource {

    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> = tvShowList

    override suspend fun saveTvShowsToCache(TvShow: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShowList)
    }
}