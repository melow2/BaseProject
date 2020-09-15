package com.khs.baseproject.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.khs.baseproject.data.model.movie.Movie
import com.khs.baseproject.data.model.tvshow.TvShow

/**
 * RoomDB와 연결되는 Dao Interface
 * @author 권혁신
 * @version 1.0.0
 * @since 2020-09-15 오후 5:32
 **/
@Dao
interface TvShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShows: List<TvShow>)

    @Query("DELETE FROM popular_tv_show")
    suspend fun deleteAllTvShows()

    @Query("SELECT * FROM popular_tv_show")
    suspend fun getTvShows(tvShows: List<TvShow>)
}