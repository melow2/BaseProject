package com.khs.baseproject.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.khs.baseproject.R
import com.khs.baseproject.databinding.ActivityArtistBinding
import com.khs.baseproject.presentation.BaseActivity

class ArtistActivity : BaseActivity<ActivityArtistBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindView(R.layout.activity_artist)
    }
}