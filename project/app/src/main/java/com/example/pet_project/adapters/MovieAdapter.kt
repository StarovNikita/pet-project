package com.example.pet_project.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pet_project.Constants
import com.example.pet_project.R
import com.example.pet_project.model.Result

class MovieAdapter(private val movieList: List<Result>, private val context: Context) :
    RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder = MovieHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
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

    class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvOverview: TextView = itemView.findViewById(R.id.tvOverView)
        val tvReleaseDate: TextView = itemView.findViewById(R.id.tvReleaseDate)
        val ivMovie: ImageView = itemView.findViewById(R.id.ivMovie)
    }
}