package com.khs.baseproject.presentation.di.core


import com.khs.baseproject.domain.repository.ArtistRepository
import com.khs.baseproject.domain.repository.MovieRepository
import com.khs.baseproject.domain.repository.TvShowRepository
import com.khs.baseproject.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMovieUsecase {
        return GetMovieUsecase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUsecase {
        return UpdateMoviesUsecase(movieRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository): GetTvShowsUsecase {
        return GetTvShowsUsecase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowsUsecase {
        return UpdateTvShowsUsecase(tvShowRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistUsecase {
        return GetArtistUsecase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistUsecase {
        return UpdateArtistUsecase(artistRepository)
    }

}