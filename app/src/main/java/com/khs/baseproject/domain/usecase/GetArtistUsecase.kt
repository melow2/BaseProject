package com.khs.baseproject.domain.usecase

import com.khs.baseproject.data.model.artist.Artist
import com.khs.baseproject.domain.repository.ArtistRepository

class GetArtistUsecase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>?  = artistRepository.getArtists()
}