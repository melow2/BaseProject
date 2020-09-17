package com.khs.baseproject.presentation.movie

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.khs.baseproject.R
import com.khs.baseproject.data.model.movie.Movie
import com.khs.baseproject.databinding.ItemListBinding
import java.util.*

class MovieAdapter(
    val mContext: Context
) : ListAdapter<Movie, MovieAdapter.MovieViewHolder>(Movie.itemCallback) {

    private lateinit var mBinding: ItemListBinding
    private var unFilteredList = listOf<Movie>()

    companion object{
        const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w500/"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_list,
            parent,
            false
        )
        return MovieViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
    }

    override fun getItemId(position: Int): Long {
        return currentList[position].id.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).id
    }

    fun modifyList(list:List<Movie>){
        unFilteredList = list
        submitList(list)
    }

    fun filter(query: CharSequence?) {
        val list = mutableListOf<Movie>()
        // perform the data filtering
        if (!query.isNullOrEmpty()) {
            for (movie in unFilteredList) {
                val content = movie.title.toLowerCase(Locale.ROOT)
                content.let {
                    if (it.contains(query.toString().toLowerCase(Locale.ROOT))) {
                        list.add(movie)
                    }
                }
            }
        } else {
            list.addAll(unFilteredList)
        }
        submitList(list)
    }

    inner class MovieViewHolder(private val mBinding: ItemListBinding) :
        RecyclerView.ViewHolder(mBinding.root) {

        init {

        }

        fun bind(movie: Movie) {
            mBinding.apply {
                tvTitle.text = movie.title
                tvDescription.text = movie.overview
                val posterURL = POSTER_BASE_URL + movie.poster_path
                Glide.with(mBinding.ivPoster.context)
                    .load(posterURL)
                    .into(mBinding.ivPoster)
            }
        }
    }

}