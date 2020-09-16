package com.khs.baseproject.presentation.di.core


import com.khs.baseproject.data.repository.artist.ArtistRepositoryImpl
import com.khs.baseproject.data.repository.artist.datasource.ArtistCacheDataSource
import com.khs.baseproject.data.repository.artist.datasource.ArtistLocalDataSource
import com.khs.baseproject.data.repository.artist.datasource.ArtistRemoteDataSource
import com.khs.baseproject.data.repository.movie.MovieRepositoryImpl
import com.khs.baseproject.data.repository.movie.datasource.MovieCacheDataSource
import com.khs.baseproject.data.repository.movie.datasource.MovieLocalDataSource
import com.khs.baseproject.data.repository.movie.datasource.MovieRemoteDataSource
import com.khs.baseproject.data.repository.tvshow.TvShowRepositoryImpl
import com.khs.baseproject.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.khs.baseproject.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.khs.baseproject.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.khs.baseproject.domain.repository.ArtistRepository
import com.khs.baseproject.domain.repository.MovieRepository
import com.khs.baseproject.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDataSource,
            movieCacheDataSource
        )


    }

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {

        return TvShowRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )


    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {

        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artistLocalDataSource,
            artistCacheDataSource
        )


    }

}