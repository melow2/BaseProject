package com.khs.baseproject.domain.repository

import com.khs.baseproject.data.model.artist.Artist
import com.khs.baseproject.data.model.movie.Movie
import com.khs.baseproject.data.model.tvshow.TvShow

interface ArtistRepository {
    suspend fun getArtists():List<Artist>?
    suspend fun updateArtists():List<Artist>?
}