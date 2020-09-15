package com.khs.baseproject.domain.repository

import com.khs.baseproject.data.model.artist.Artist
import com.khs.baseproject.data.model.movie.Movie
import com.khs.baseproject.data.model.tvshow.TvShow

interface MovieRepository {
    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
}