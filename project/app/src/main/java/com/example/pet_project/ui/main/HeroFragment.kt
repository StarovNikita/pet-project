package com.example.pet_project.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pet_project.R
import com.example.pet_project.databinding.FragmentHeroBinding
import com.example.pet_project.model.hero.Result
import com.bumptech.glide.Glide

class HeroFragment : Fragment(R.layout.fragment_hero) {

    private lateinit var binding: FragmentHeroBinding
    private val selectedHero: Result? = arguments?.getParcelable("selectedHero")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentHeroBinding.inflate(layoutInflater)
        setViewContent()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_hero, container, false)

    private fun setViewContent(){
        with(selectedHero) {
            context?.let { Glide.with(it).load(this?.image?.url).into(binding.imageView) }
            binding.selectedHeroName.text = this?.name
            binding.selectedHeroCombat.text = this?.powerstats?.combat
            binding.selectedHeroDurability.text = this?.powerstats?.durability
            binding.selectedHeroIntelligence.text = this?.powerstats?.intelligence
            binding.selectedHeroPower.text = this?.powerstats?.power
            binding.selectedHeroSpeed.text = this?.powerstats?.speed
            binding.selectedHeroStrength.text = this?.powerstats?.strength
            binding.selectedHeroGender.text = this?.appearance?.gender
            binding.selectedHeroRace.text = this?.appearance?.race
        }
    }
}