package com.khs.baseproject.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.khs.baseproject.R
import com.khs.baseproject.databinding.ActivityHomeBinding
import com.khs.baseproject.presentation.artist.ArtistActivity
import com.khs.baseproject.presentation.movie.MovieActivity
import com.khs.baseproject.presentation.tvshow.TvShowActivity

class HomeActivity : BaseActivity<ActivityHomeBinding>(){

    private val buttonListener = View.OnClickListener {
        when(it.id){
            R.id.btn_movie ->{
                startActivity(Intent(this,MovieActivity::class.java))
            }
            R.id.btn_artist ->{
                startActivity(Intent(this,ArtistActivity::class.java))
            }
            R.id.btn_tvshow ->{
                startActivity(Intent(this,TvShowActivity::class.java))
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindView(R.layout.activity_home)
        setUpListener()
    }

    private fun setUpListener() {
        mBinding?.apply {
            btnArtist.setOnClickListener(buttonListener)
            btnMovie.setOnClickListener(buttonListener)
            btnTvshow.setOnClickListener(buttonListener)
        }
    }

}