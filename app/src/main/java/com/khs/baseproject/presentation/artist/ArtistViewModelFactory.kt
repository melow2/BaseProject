package com.khs.baseproject.presentation.artist

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.khs.baseproject.domain.usecase.GetArtistUsecase
import com.khs.baseproject.domain.usecase.GetMovieUsecase
import com.khs.baseproject.domain.usecase.UpdateArtistUsecase
import com.khs.baseproject.domain.usecase.UpdateMoviesUsecase

class ArtistViewModelFactory(
    private val mApplication: Application,
    private val getArtistUsecase: GetArtistUsecase,
    private val updateArtistUsecase: UpdateArtistUsecase

) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ArtistViewModel(mApplication, getArtistUsecase,updateArtistUsecase) as T
    }
}