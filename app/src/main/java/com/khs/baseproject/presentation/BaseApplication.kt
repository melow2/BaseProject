package com.khs.baseproject.presentation

import android.content.Context
import androidx.multidex.MultiDexApplication
import com.khs.baseproject.presentation.di.Injector
import com.khs.baseproject.presentation.di.artist.ArtistSubComponent
import com.khs.baseproject.presentation.di.core.*
import com.khs.baseproject.presentation.di.movie.MovieSubComponent
import com.khs.baseproject.presentation.di.tvshow.TvShowSubComponent
import timber.log.Timber

class BaseApplication : MultiDexApplication(), Injector {

    private lateinit var appComponent: AppComponent

    companion object {
        const val API_KEY = "b1be3e49b0412cc511ec689e39ce76f6"
        const val BASE_URL = "https://api.themoviedb.org/3/"
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        Timber.plant(Timber.DebugTree())
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext,this))
            .netModule(NetModule(BASE_URL))
            .remoteDataModule(RemoteDataModule(API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

}