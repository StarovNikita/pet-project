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

    private lateinit var selectedHero: Result
    private lateinit var binding: FragmentHeroBinding

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
            context?.let { Glide.with(it).load(image.url).into(binding.imageView) }
            binding.selectedHeroName.text = name
            binding.selectedHeroCombat.text = powerstats.combat
            binding.selectedHeroDurability.text = powerstats.durability
            binding.selectedHeroIntelligence.text = powerstats.intelligence
            binding.selectedHeroPower.text = powerstats.power
            binding.selectedHeroSpeed.text = powerstats.speed
            binding.selectedHeroStrength.text = powerstats.strength
            binding.selectedHeroGender.text = appearance.gender
            binding.selectedHeroRace.text = appearance.race
        }
    }
}