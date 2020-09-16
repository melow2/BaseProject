package com.khs.baseproject.presentation.artist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.liveData
import com.khs.baseproject.domain.usecase.GetArtistUsecase
import com.khs.baseproject.domain.usecase.GetMovieUsecase
import com.khs.baseproject.domain.usecase.UpdateArtistUsecase
import com.khs.baseproject.domain.usecase.UpdateMoviesUsecase

class ArtistViewModel(
    application: Application,
    private val getArtistUsecase: GetArtistUsecase,
    private val updateArtistUsecase: UpdateArtistUsecase
):AndroidViewModel(application),LifecycleObserver {

    fun getArtists() = liveData {
        val artistList = getArtistUsecase.execute()
        emit(artistList)
    }

    fun updateArtists() = liveData {
        val artistList = updateArtistUsecase.execute()
        emit(artistList)
    }

}