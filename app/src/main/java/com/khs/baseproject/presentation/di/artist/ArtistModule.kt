package com.khs.baseproject.presentation.di.artist

import android.app.Application
import com.khs.baseproject.domain.usecase.GetArtistUsecase
import com.khs.baseproject.domain.usecase.UpdateArtistUsecase
import com.khs.baseproject.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        application: Application,
        getArtistsUseCase: GetArtistUsecase,
        updateArtistsUseCase: UpdateArtistUsecase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            application,
            getArtistsUseCase,
            updateArtistsUseCase
        )
    }

}