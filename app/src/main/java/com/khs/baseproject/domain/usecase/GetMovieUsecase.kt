package com.khs.baseproject.domain.usecase

import com.khs.baseproject.data.model.movie.Movie
import com.khs.baseproject.domain.repository.MovieRepository

class GetMovieUsecase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>?  = movieRepository.getMovies()
}