package com.example.pet_project.adapters

import android.content.Context

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pet_project.databinding.HeroItemBinding
import com.example.pet_project.model.hero.Result
import com.example.pet_project.ui.main.MainActivity
import com.example.pet_project.ui.main.MainPresenter

class HeroAdapter(
    private var heroList: List<Result>,
    private val context: Context?,
    private val mainPresenter: MainPresenter,
    private val activity: MainActivity
) :
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
            mainPresenter.heroCardClicked(heroList[position],activity)
        }
    }

    override fun getItemCount(): Int = heroList.size

    fun update(newHeroList: List<Result>) {
        heroList = newHeroList
    }

    class HeroHolder(binding: HeroItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val heroName: TextView = binding.heroName
        val heroGender: TextView = binding.heroGender
        val heroRace: TextView = binding.heroRace
        val heroImage: ImageView = binding.heroImage
        val heroCard: CardView = binding.heroCard
    }
}