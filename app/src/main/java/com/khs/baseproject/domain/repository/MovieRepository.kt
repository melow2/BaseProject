package com.khs.baseproject.domain.repository

import com.khs.baseproject.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}