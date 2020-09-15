package com.khs.baseproject.data.model.movie

/**
 *
 * 원래는 다른 필드 속성도 있었지만 movie 리스트만 가져옴.
 * @author 권혁신
 * @version 1.0.0
 * @since 2020-09-15 오후 5:10
 **/
data class MovieList(
    val movies: List<Movie>
)