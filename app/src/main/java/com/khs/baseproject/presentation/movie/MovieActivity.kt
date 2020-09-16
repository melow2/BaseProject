package com.khs.baseproject.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.khs.baseproject.R
import com.khs.baseproject.databinding.ActivityMovieBinding
import com.khs.baseproject.presentation.BaseActivity
import com.khs.baseproject.presentation.di.Injector
import timber.log.Timber
import javax.inject.Inject

class MovieActivity : BaseActivity<ActivityMovieBinding>() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel:MovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindView(R.layout.activity_movie)
        (application as Injector).createMovieSubComponent().inject(this)
        movieViewModel =  ViewModelProvider(this,factory).get(MovieViewModel::class.java)
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this, {
            Timber.d("${it.toString()}")
        })
    }
}