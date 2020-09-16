package com.khs.baseproject.domain.repository

import com.khs.baseproject.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}