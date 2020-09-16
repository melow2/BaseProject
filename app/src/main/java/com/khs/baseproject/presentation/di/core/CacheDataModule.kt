package com.khs.baseproject.presentation.di.core


import com.khs.baseproject.data.repository.artist.datasource.ArtistCacheDataSource
import com.khs.baseproject.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.khs.baseproject.data.repository.movie.datasource.MovieCacheDataSource
import com.khs.baseproject.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.khs.baseproject.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.khs.baseproject.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }


}