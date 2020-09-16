package com.khs.baseproject.presentation.di.core

import com.khs.baseproject.data.db.ArtistDao
import com.khs.baseproject.data.db.MovieDao
import com.khs.baseproject.data.db.TvShowDao
import com.khs.baseproject.data.repository.artist.datasource.ArtistLocalDataSource
import com.khs.baseproject.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.khs.baseproject.data.repository.movie.datasource.MovieLocalDataSource
import com.khs.baseproject.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.khs.baseproject.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.khs.baseproject.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao : ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }


}