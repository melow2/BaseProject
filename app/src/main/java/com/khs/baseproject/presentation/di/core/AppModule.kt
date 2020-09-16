package com.khs.baseproject.presentation.di.core

import android.app.Application
import android.content.Context
import com.khs.baseproject.presentation.di.artist.ArtistSubComponent
import com.khs.baseproject.presentation.di.movie.MovieSubComponent
import com.khs.baseproject.presentation.di.tvshow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(subcomponents = [MovieSubComponent::class, TvShowSubComponent::class, ArtistSubComponent::class])
class AppModule(private val context: Context,private val app:Application) {

    @Singleton
    @Provides
    fun provideApplication(): Application {
        return app
    }

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}





