package com.khs.baseproject.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.khs.baseproject.data.model.artist.Artist
import com.khs.baseproject.data.model.movie.Movie
import com.khs.baseproject.data.model.tvshow.TvShow

@Database(entities = [Movie::class,TvShow::class,Artist::class], version = 1, exportSchema = false)
abstract class TMDBDatabase :RoomDatabase(){
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}