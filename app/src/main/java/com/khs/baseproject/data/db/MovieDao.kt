package com.khs.baseproject.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.khs.baseproject.data.model.movie.Movie


/**
 * RoomDB와 연결되는 Dao Interface
 * @author 권혁신
 * @version 1.0.0
 * @since 2020-09-15 오후 5:32
 **/
@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("DELETE FROM popular_movies")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM popular_movies")
    suspend fun getMovies(): List<Movie>
}