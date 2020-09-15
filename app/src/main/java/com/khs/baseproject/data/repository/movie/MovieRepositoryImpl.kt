package com.khs.baseproject.data.repository.movie

import com.khs.baseproject.data.model.movie.Movie
import com.khs.baseproject.data.repository.movie.datasource.MovieCacheDataSource
import com.khs.baseproject.data.repository.movie.datasource.MovieLocalDataSource
import com.khs.baseproject.data.repository.movie.datasource.MovieRemoteDataSource
import com.khs.baseproject.domain.repository.MovieRepository
import timber.log.Timber
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI():List<Movie>{
        lateinit var movieList:List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if(body!=null){
                movieList = body.movies
            }
        }catch (e:Exception){
            Timber.d(e.printStackTrace().toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDB():List<Movie>{
        lateinit var movieList:List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        }catch (e:Exception){
            Timber.d(e.printStackTrace().toString())
        }
        if(movieList.isNotEmpty()) return movieList
        else {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache():List<Movie>{
        lateinit var movieList:List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (e:Exception){
            Timber.d(e.printStackTrace().toString())
        }
        if(movieList.isNotEmpty()) return movieList
        else {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}