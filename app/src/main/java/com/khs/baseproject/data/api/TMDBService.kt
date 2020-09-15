package com.khs.baseproject.data.api

import com.khs.baseproject.data.model.artist.ArtistList
import com.khs.baseproject.data.model.movie.MovieList
import com.khs.baseproject.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 영화, TV SHOW, 아티스트의 목록을 받아 올 수 있는 API Service.
 *
 * ex) https://api.themoviedb.org/3/movie/{movie_id}?api_key=b1be3e49b0412cc511ec689e39ce76f6&language=en-US
 * #1 baseUrl ===> https://api.themoviedb.org/3/
 * #2 endPoint ===> movie/{movie_id}
 * #3 queryParam ===> api_key=b1be3e49b0412cc511ec689e39ce76f6&language=en-US
 * @author 권혁신
 * @version 1.0.0
 * @since 2020-09-15 오후 5:07
 **/
interface TMDBService {
    companion object {
        const val PARAM_API_KEY = "api_key" // api key
        const val END_POINT_GET_MOVIES = "movie/popular"
        const val END_POINT_GET_TVSHOWS = "tv/popular"
        const val END_POINT_GET_ARTISTS = "person/popular"
    }
    @GET(END_POINT_GET_MOVIES)
    suspend fun getPopularMovies(@Query(PARAM_API_KEY) apiKey: String): Response<MovieList>
    @GET(END_POINT_GET_TVSHOWS)
    suspend fun getPopularTvShows(@Query(PARAM_API_KEY) apiKey: String): Response<TvShowList>
    @GET(END_POINT_GET_ARTISTS)
    suspend fun getPopularArtists(@Query(PARAM_API_KEY) apiKey: String): Response<ArtistList>
}