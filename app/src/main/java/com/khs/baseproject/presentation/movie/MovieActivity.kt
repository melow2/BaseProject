package com.khs.baseproject.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.khs.baseproject.R
import com.khs.baseproject.databinding.ActivityMovieBinding
import com.khs.baseproject.presentation.BaseActivity

class MovieActivity : BaseActivity<ActivityMovieBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindView(R.layout.activity_movie)
    }
}