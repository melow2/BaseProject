package com.khs.baseproject.presentation.movie

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.khs.baseproject.R
import com.khs.baseproject.data.model.movie.Movie
import com.khs.baseproject.databinding.ActivityMovieBinding
import com.khs.baseproject.presentation.BaseActivity
import com.khs.baseproject.presentation.di.Injector
import timber.log.Timber
import javax.inject.Inject

class MovieActivity : BaseActivity<ActivityMovieBinding>() {
    @Inject
    lateinit var mFactory: MovieViewModelFactory
    private lateinit var mMovieViewModel: MovieViewModel
    private lateinit var mAdapter: MovieAdapter

    private val observerGetMovies: Observer<List<Movie>?> = Observer { list ->
        if (!list.isNullOrEmpty()) {
            mAdapter.modifyList(list)
        }else{
            showToast(this,"No data available")
        }
        mBinding?.pgbMovie?.visibility = View.GONE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindView(R.layout.activity_movie)
        (application as Injector).createMovieSubComponent().inject(this)
        mMovieViewModel = ViewModelProvider(this, mFactory).get(MovieViewModel::class.java)
        initRecyclerView()
        displayPopularMovies()
    }

    private fun displayPopularMovies() {
        mBinding?.pgbMovie?.visibility = View.VISIBLE
        val responseLiveData = mMovieViewModel.getMovies()
        responseLiveData.observe(this,observerGetMovies)

    }

    private fun initRecyclerView() {
        mAdapter = MovieAdapter(this)
        mBinding?.rcvMovie?.apply {
            // layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL)
            layoutManager = LinearLayoutManager(this@MovieActivity)
            this.adapter = mAdapter
            setHasFixedSize(true)   // 깜빡임 제거.
        }
    }
}