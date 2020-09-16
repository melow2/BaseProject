package com.khs.baseproject.data.repository.artist.datasource

import com.khs.baseproject.data.model.artist.ArtistList
import com.khs.baseproject.data.model.movie.MovieList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}