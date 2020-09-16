package com.khs.baseproject.data.repository.artist.datasource

import com.khs.baseproject.data.model.artist.Artist
import com.khs.baseproject.data.model.movie.Movie
import com.khs.baseproject.data.model.movie.MovieList
import retrofit2.Response

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache():List<Artist>
    suspend fun saveArtistsToCache(movies:List<Artist>)
}