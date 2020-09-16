package com.khs.baseproject.presentation.di

import com.khs.baseproject.presentation.di.artist.ArtistSubComponent
import com.khs.baseproject.presentation.di.movie.MovieSubComponent
import com.khs.baseproject.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}