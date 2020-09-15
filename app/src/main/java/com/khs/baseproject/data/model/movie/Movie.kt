package com.khs.baseproject.data.model.movie

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * tableName으로 사용자가 정의해서 table의 이름을 지정할 수 있음.
 * ColumnInfo 어노테이션으로 컬럼이름도 임의로 지정할 수 있음.
 * @author 권혁신
 * @version 1.0.0
 * @since 2020-09-15 오후 5:26
 **/
@Entity(tableName = "popular_movies")
data class Movie(
    @PrimaryKey
    val id: Int,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val title: String
)