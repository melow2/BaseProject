package com.khs.baseproject.data.repository.movie.datasource

import com.khs.baseproject.data.model.movie.Movie
import com.khs.baseproject.data.model.movie.MovieList
import retrofit2.Response

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesToCache(movies:List<Movie>)
}