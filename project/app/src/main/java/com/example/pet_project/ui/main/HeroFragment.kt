package com.example.pet_project.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.arellomobile.mvp.MvpAppCompatFragment
import com.example.pet_project.databinding.FragmentHeroBinding
import com.example.pet_project.model.hero.Result
import com.bumptech.glide.Glide

class HeroFragment : MvpAppCompatFragment() {

    private lateinit var binding: FragmentHeroBinding
    private lateinit var selectedHero : Result
    private val args : HeroFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHeroBinding.inflate(inflater, container, false)
        setViewContent()
        return binding.root
    }

    private fun setViewContent() {
        selectedHero = args.selectedHero
        with(selectedHero) {
            context?.let { Glide.with(it).load(image?.url).into(binding.imageView) }
            binding.selectedHeroName.text = name
            binding.selectedHeroCombat.text = powerstats?.combat
            binding.selectedHeroDurability.text = powerstats?.durability
            binding.selectedHeroIntelligence.text = powerstats?.intelligence
            binding.selectedHeroPower.text = powerstats?.power
            binding.selectedHeroSpeed.text = powerstats?.speed
            binding.selectedHeroStrength.text = powerstats?.strength
            binding.selectedHeroGender.text = appearance?.gender
            binding.selectedHeroRace.text = appearance?.race
        }
    }
}