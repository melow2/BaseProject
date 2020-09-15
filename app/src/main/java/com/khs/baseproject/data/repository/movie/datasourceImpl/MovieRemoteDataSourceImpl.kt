package com.khs.baseproject.data.repository.movie.datasourceImpl

import com.khs.baseproject.data.api.TMDBService
import com.khs.baseproject.data.model.movie.MovieList
import com.khs.baseproject.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apikey:String
): MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apikey)
}