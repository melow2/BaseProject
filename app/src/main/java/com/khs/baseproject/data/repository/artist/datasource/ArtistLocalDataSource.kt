package com.khs.baseproject.data.repository.artist.datasource

import com.khs.baseproject.data.model.artist.Artist
import com.khs.baseproject.data.model.movie.Movie
import com.khs.baseproject.data.model.movie.MovieList
import retrofit2.Response

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB(): List<Artist>
    suspend fun saveArtistsToDB(movies:List<Artist>)
    suspend fun clearAll()
}