package com.example.pet_project.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pet_project.databinding.HeroItemBinding
import com.example.pet_project.model.hero.Result

class HeroAdapter(private val heroList: List<Result>, private val context: Context) :
    RecyclerView.Adapter<HeroAdapter.HeroHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder = HeroHolder(
        HeroItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        with(heroList[position]) {
            holder.heroName.text = name
            holder.heroGender.text = appearance.gender
            holder.heroRace.text = appearance.race
            Glide.with(context).load(image.url)
                .into(holder.heroImage)
        }
    }

    override fun getItemCount(): Int = heroList.size

    class HeroHolder(binding: HeroItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val heroName: TextView = binding.heroName
        val heroGender: TextView = binding.heroGender
        val heroRace: TextView = binding.heroRace
        val heroImage: ImageView = binding.heroImage
    }
}