package com.khs.baseproject.data.model.tvshow

/**
 *
 * 원래 다른 필드가 있었지만 TvShow 리스트만 불러옴.
 * @author 권혁신
 * @version 1.0.0
 * @since 2020-09-15 오후 5:18
 **/
data class TvShowList(
    val tvShows: List<TvShow>
)