package com.example.pet_project.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pet_project.R
import com.example.pet_project.databinding.HeroItemBinding
import com.example.pet_project.model.hero.Result
import com.example.pet_project.ui.main.HeroFragment
import com.example.pet_project.utils.navigate

class HeroAdapter(private val heroList: List<Result>, private val context: Context?) :
    RecyclerView.Adapter<HeroAdapter.HeroHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder = HeroHolder(
        HeroItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        with(heroList[position]) {
            holder.heroName.text = name
            holder.heroGender.text = appearance.gender
            holder.heroRace.text = appearance.race
            context?.let {
                Glide.with(it).load(image.url)
                    .into(holder.heroImage)
            }
        }
        holder.heroCard.setOnClickListener {
            val fragment = HeroFragment(heroList[position])
            fragment.navigate(R.id.action_initialFragment_to_detailsFragment)
        }
    }

    override fun getItemCount(): Int = heroList.size

    class HeroHolder(binding: HeroItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val heroName: TextView = binding.heroName
        val heroGender: TextView = binding.heroGender
        val heroRace: TextView = binding.heroRace
        val heroImage: ImageView = binding.heroImage
        val heroCard : CardView = binding.heroCard
    }
}