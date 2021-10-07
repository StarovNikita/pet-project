package com.example.pet_project.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pet_project.Constants
import com.example.pet_project.databinding.MovieItemBinding
import com.example.pet_project.model.Result

class MovieAdapter(private val movieList: List<Result>, private val context: Context) :
    RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder = MovieHolder(
        MovieItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        with(movieList[position]) {
            holder.tvTitle.text = title
            holder.tvOverview.text = overview
            holder.tvReleaseDate.text = releaseDate
            Glide.with(context).load("${Constants.IMAGE_URL}${posterPath}")
                .into(holder.ivMovie)
        }
    }

    override fun getItemCount(): Int = movieList.size

    class MovieHolder(binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvTitle: TextView = binding.tvTitle
        val tvOverview: TextView = binding.tvOverView
        val tvReleaseDate: TextView = binding.tvReleaseDate
        val ivMovie: ImageView = binding.ivMovie
    }
}