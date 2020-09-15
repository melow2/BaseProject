package com.khs.baseproject.domain.usecase

import com.khs.baseproject.data.model.artist.Artist
import com.khs.baseproject.domain.repository.ArtistRepository

class UpdateArtistUsecase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>?  = artistRepository.updateArtists()
}