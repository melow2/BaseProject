package com.khs.baseproject.data.repository.movie.datasource

import com.khs.baseproject.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}