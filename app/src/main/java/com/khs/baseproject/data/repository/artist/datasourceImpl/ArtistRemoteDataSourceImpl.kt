package com.khs.baseproject.data.repository.artist.datasourceImpl

import com.khs.baseproject.data.api.TMDBService
import com.khs.baseproject.data.model.artist.ArtistList
import com.khs.baseproject.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apikey:String
): ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apikey)
}