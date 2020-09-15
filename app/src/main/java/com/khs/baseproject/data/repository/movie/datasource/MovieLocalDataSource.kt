package com.khs.baseproject.data.repository.movie.datasource

import com.khs.baseproject.data.model.movie.Movie
import com.khs.baseproject.data.model.movie.MovieList
import retrofit2.Response

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies:List<Movie>)
    suspend fun clearAll()
}