package com.khs.baseproject.data.repository.artist

import com.khs.baseproject.data.model.artist.Artist
import com.khs.baseproject.data.model.movie.Movie
import com.khs.baseproject.data.repository.artist.datasource.ArtistCacheDataSource
import com.khs.baseproject.data.repository.artist.datasource.ArtistLocalDataSource
import com.khs.baseproject.data.repository.artist.datasource.ArtistRemoteDataSource
import com.khs.baseproject.data.repository.movie.datasource.MovieCacheDataSource
import com.khs.baseproject.data.repository.movie.datasource.MovieLocalDataSource
import com.khs.baseproject.data.repository.movie.datasource.MovieRemoteDataSource
import com.khs.baseproject.domain.repository.ArtistRepository
import com.khs.baseproject.domain.repository.MovieRepository
import timber.log.Timber
import java.lang.Exception

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {

    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfMovies = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfMovies)
        artistCacheDataSource.saveArtistsToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getArtistsFromAPI():List<Artist>{
        lateinit var artistList:List<Artist>
        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if(body!=null){
                artistList = body.artists
            }
        }catch (e:Exception){
            Timber.d(e.printStackTrace().toString())
        }
        return artistList
    }

    suspend fun getArtistsFromDB():List<Artist>{
        lateinit var artistList:List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistsFromDB()
        }catch (e:Exception){
            Timber.d(e.printStackTrace().toString())
        }
        if(artistList.isNotEmpty()) return artistList
        else {
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistsFromCache():List<Artist>{
        lateinit var artistList:List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistsFromCache()
        }catch (e:Exception){
            Timber.d(e.printStackTrace().toString())
        }
        if(artistList.isNotEmpty()) return artistList
        else {
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }
        return artistList
    }
}