package com.khs.baseproject.presentation.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.khs.baseproject.R
import com.khs.baseproject.databinding.ActivityTvShowBinding
import com.khs.baseproject.presentation.BaseActivity

class TvShowActivity : BaseActivity<ActivityTvShowBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindView(R.layout.activity_tv_show)
    }
}